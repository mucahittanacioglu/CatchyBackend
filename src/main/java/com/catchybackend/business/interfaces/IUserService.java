package com.catchybackend.business.interfaces;

import com.catchybackend.business.dtos.UserLoginDto;
import com.catchybackend.models.User;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<String> login(UserLoginDto user);
    ResponseEntity<String> register(User user);

}
