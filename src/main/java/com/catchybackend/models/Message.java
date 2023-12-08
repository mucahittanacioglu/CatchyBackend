package com.catchybackend.models;

import com.ts.core.entities.IEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "message")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Message extends IEntity {

    @ManyToOne()
    @Column(name = "owner_user")
    private User owner;

    @OneToMany(mappedBy = "ownerMessage", cascade = CascadeType.ALL)
    private List<MessageDetails> messageDetails;

    @ManyToOne
    @Column(name="receiver_user")
    private User receiverUser;

}
