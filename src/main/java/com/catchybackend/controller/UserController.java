package com.catchybackend.controller;

import com.catchybackend.business.interfaces.IUserService;
import com.catchybackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody User user) {
        return userService.update(user);
    }
    @PostMapping("/addFriend")
    public ResponseEntity<Boolean> addFriend(@RequestParam(name="userId")Long userId, @RequestParam(name="friendId")Long friendId){
        return userService.addFriend(userId,friendId);
    }
    @GetMapping("/getFriends")
    public ResponseEntity<List<User>> getFriends(@RequestParam(name="userId")Long userId)
    {
        return userService.getFriends(userId);
    }
}
