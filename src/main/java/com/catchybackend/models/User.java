package com.catchybackend.models;

import com.ts.core.entities.IUser;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")@Data
public class User extends IUser {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "first_name")
    private String lastName;

    @ManyToMany(mappedBy = "participants")
    private Set<Conversation> conversations = new HashSet<>();

}
