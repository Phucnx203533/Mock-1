package com.example.mock1.controller;

import com.example.mock1.dto.JwtTokenDto;
import com.example.mock1.dto.LoginRequestDto;
import com.example.mock1.service.AuthService;
import com.example.mock1.utils.respone.CommonResult;
import com.example.mock1.utils.respone.ResCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public CommonResult login(@RequestBody LoginRequestDto loginRequestDto) {
        JwtTokenDto jwtTokenDto = authService.sigin(loginRequestDto);
        return CommonResult.success(jwtTokenDto);
    }

    @PostMapping("/logout")
    public CommonResult logoutUser() {
        authService.signout();
        return CommonResult.success("You've been signed out!");
    }

    @PostMapping("/refreshToken")
    public CommonResult refreshToken(@RequestBody JwtTokenDto jwtTokenDto) {
        JwtTokenDto result = authService.refreshToken(jwtTokenDto.getRefreshToken());
        if (result == null){
            return new CommonResult(ResCode.REFRESH_TOKEN_NOT_EXISTS);
        }
        return CommonResult.success(result);
    }
}
