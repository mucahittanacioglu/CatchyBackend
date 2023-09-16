package com.catchybackend.controller;

import com.catchybackend.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @PostMapping("/login")
    public String login(@RequestBody User user) throws InterruptedException {
        Thread.sleep(10000);
        return "Login Success"+ user;
    }
}
