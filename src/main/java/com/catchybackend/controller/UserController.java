package com.catchybackend.controller;

import com.catchybackend.business.concrete.UserService;
import com.catchybackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }
    @PostMapping("/register")
    public String register(@RequestBody User user){
        return userService.register(user);
    }
    @PostMapping("/update")
    public String update(@RequestBody User user){
        return userService.update(user);
    }
}
