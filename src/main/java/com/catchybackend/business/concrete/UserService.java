package com.catchybackend.business.concrete;

import com.catchybackend.business.interfaces.IUserService;
import com.catchybackend.dataaccess.UserRepository;
import com.catchybackend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public String register(User user) {
        return userRepository.save(user).toString();
    }
    public String update(User user){
        return userRepository.save(user).toString();
    }
}
