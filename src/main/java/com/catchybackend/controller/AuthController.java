package com.catchybackend.controller;

import com.catchybackend.business.concrete.AuthService;
import com.catchybackend.business.dtos.UserLoginDto;
import com.catchybackend.business.dtos.UserRegisterDto;
import com.catchybackend.business.interfaces.IAuthService;
import com.catchybackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
    @Autowired
    IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto user) {
        return authService.login(user);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterDto user) {
        User userToRegister = new User();
        userToRegister.setFirstName(user.getFirstName());
        userToRegister.setLastName(user.getLastName());
        userToRegister.setEmail(user.getEmail());
        userToRegister.setPassword(user.getPassword());
        userToRegister.setRoles(null);
        return authService.register(userToRegister);
    }


}
