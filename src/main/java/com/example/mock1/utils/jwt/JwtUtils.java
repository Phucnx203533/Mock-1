package com.example.mock1.utils.jwt;


import com.example.mock1.config.security.service.UserDetailsImpl;
import com.example.mock1.entity.EmployeeEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Component
@Slf4j
public class JwtUtils {

    @Value("${app.jwtCookieName}")
    private String jwtCookieName;

    @Value("${app.jwtExpiration}")
    private int jwtExpiration;

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtRefreshCookieName}")
    private String jwtRefreshCookieName;

    public String getJwtFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request,jwtCookieName);
        if(cookie == null){
            return null;
        }
        return cookie.getValue();
    }

    public ResponseCookie generateJwtCookie(UserDetailsImpl principal){
        String jwt = generateTokenFromUsername(principal.getUsername());
        ResponseCookie cookie = ResponseCookie.from(jwtCookieName, jwt).maxAge(24 * 60 * 60).httpOnly(true).build();
        return cookie;
    }
    public String generateRefeshToken(HashMap<String, Object> claims,UserDetailsImpl principal){
        return Jwts.builder()
                .addClaims(claims)
                .setSubject(principal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 24*60*60*1000))
                .signWith(key())
                .compact();
    }

    public ResponseCookie getCleanJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(jwtCookieName, null).build();
        return cookie;
    }
    public ResponseCookie getJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(jwtRefreshCookieName, null).build();
        return cookie;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 30*60*1000))
                .signWith(key())
                .compact();
    }
    public String parseJwt(HttpServletRequest request) {
        String jwt = getJwtFromCookies(request);
        return jwt;
    }

    public boolean isTokenValid(String token, EmployeeEntity employeeEntity){
        final String username = getUserNameFromJwtToken(token);
        return (username.equals(employeeEntity.getAccount()) && validateJwtToken(token));
    }
}
