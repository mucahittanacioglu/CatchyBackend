package com.catchybackend.models;

import com.ts.core.entities.IUser;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")@Data
public class User extends IUser {
    private String firstName;
    private String lastName;
}
