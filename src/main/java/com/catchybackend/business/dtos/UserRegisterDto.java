package com.catchybackend.business.dtos;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
