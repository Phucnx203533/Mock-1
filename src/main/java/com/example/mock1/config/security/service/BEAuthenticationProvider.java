package com.example.mock1.config.security.service;

import com.example.mock1.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class BEAuthenticationProvider implements AuthenticationProvider  {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
        log.debug("------------Authenticate-------------");

        if(!bCryptPasswordEncoder.matches(password,userDetails.getPassword())){
            log.debug("{} Wrong password",username);
            throw new InternalAuthenticationServiceException("Invalid user");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());

    }
    // supports method returns true because it supports any type of authentication.
    // This means that the authentication provider can be used to authenticate any type of authentication token.
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
