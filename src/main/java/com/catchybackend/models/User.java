package com.catchybackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ts.core.entities.IUser;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")@Data
public class User extends IUser {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    @ManyToMany(mappedBy = "participants")
    private Set<Conversation> conversations = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> friends = new ArrayList<>();
}
