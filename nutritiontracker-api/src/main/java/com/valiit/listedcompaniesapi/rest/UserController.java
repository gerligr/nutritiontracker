package com.valiit.listedcompaniesapi.rest;

import com.valiit.listedcompaniesapi.dto.GenericResponseDto;
import com.valiit.listedcompaniesapi.dto.JwtRequestDto;
import com.valiit.listedcompaniesapi.dto.JwtResponseDto;
import com.valiit.listedcompaniesapi.dto.UserRegistrationDto;
import com.valiit.listedcompaniesapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public GenericResponseDto register(@RequestBody UserRegistrationDto userRegistration) {
        return userService.register(userRegistration);
    }

    @PostMapping("/login")
    public JwtResponseDto authenticate(@RequestBody JwtRequestDto request) throws Exception {
        return userService.authenticate(request);
    }
}