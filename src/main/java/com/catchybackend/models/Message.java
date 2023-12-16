package com.catchybackend.models;

import com.ts.core.entities.IEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Message extends IEntity {

    @ManyToOne
    private Conversation ownerConversation;

    @Column(name = "text")
    private String text;

    @ManyToOne
    private User sender;

    private LocalDateTime timestamp;
}
