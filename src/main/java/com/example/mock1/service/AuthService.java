package com.example.mock1.service;

import com.example.mock1.dto.JwtTokenDto;
import com.example.mock1.dto.LoginRequestDto;
import org.springframework.http.ResponseCookie;

public interface AuthService {

    JwtTokenDto sigin(LoginRequestDto loginRequestDto);


    void signout();

    JwtTokenDto refreshToken(String refreshToken);
}
