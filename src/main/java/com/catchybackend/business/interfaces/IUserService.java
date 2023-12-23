package com.catchybackend.business.interfaces;

import com.catchybackend.business.dtos.UserLoginDto;
import com.catchybackend.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<Boolean> addFriend(Long userId,Long friendId);
    ResponseEntity<List<User>> getFriends(Long userId);
    ResponseEntity<String> update(User user);
}
