package com.catchybackend.models;

import lombok.Data;

@Data
public class User {
    String email;
    String password;
    @Override
    public String toString(){
        return this.email+" "+ this.password;
    }
}
