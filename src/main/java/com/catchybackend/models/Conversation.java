package com.catchybackend.models;

import com.ts.core.entities.IEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "conversation")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Conversation extends IEntity {

    @ManyToMany
    @JoinTable(
            name = "conversation_participants",
            joinColumns = @JoinColumn(name = "conversation_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> participants = new HashSet<>();

    @OneToMany(mappedBy = "ownerConversation", cascade = CascadeType.ALL)
    private List<Message> messages;


}

