package com.catchybackend.business.interfaces;

import com.catchybackend.models.User;

public interface IUserService {
    String login(User user);
    String register(User user);

}
