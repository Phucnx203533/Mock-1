package com.example.mock1.service.Impl;

import com.example.mock1.config.security.service.UserDetailsImpl;
import com.example.mock1.dto.JwtTokenDto;
import com.example.mock1.dto.LoginRequestDto;
import com.example.mock1.entity.EmployeeEntity;
import com.example.mock1.repository.EmployeeRepository;
import com.example.mock1.service.AuthService;
import com.example.mock1.service.EmployeeService;
import com.example.mock1.utils.jwt.JwtUtils;
import com.example.mock1.utils.respone.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private  JwtUtils jwtUtils;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public JwtTokenDto sigin(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String accessToken = jwtUtils.generateTokenFromUsername(userDetails.getUsername());
        String refreshToken = jwtUtils.generateRefeshToken(new HashMap<>(),userDetails);
        userDetails.getEmployeeEntity().setRefeshToken(refreshToken);
        employeeRepository.save(userDetails.getEmployeeEntity());
        JwtTokenDto jwtTokenDto = new JwtTokenDto(accessToken, refreshToken);
        return jwtTokenDto;
    }

    @Override
    public void signout() {
//        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
//        return cookie;
    }

    @Override
    public JwtTokenDto refreshToken(String refreshToken) {
        String userName = jwtUtils.getUserNameFromJwtToken(refreshToken);
        EmployeeEntity entity = employeeRepository.findByAccount(userName);
        if(jwtUtils.isTokenValid(refreshToken,entity)){
            String accessToken = jwtUtils.generateTokenFromUsername(userName);
            JwtTokenDto jwtTokenDto = new JwtTokenDto(accessToken, refreshToken);
            return jwtTokenDto;
        }
        return null;
    }
}
