package com.catchybackend.models;

import com.ts.core.entities.IUser;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "user")@Data
public class User extends IUser {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "first_name")
    private String lastName;

    @OneToMany(mappedBy = "ownerUser", cascade = CascadeType.ALL)
    private List<Message> messages;

}
