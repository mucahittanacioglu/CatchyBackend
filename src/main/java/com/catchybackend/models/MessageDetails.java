package com.catchybackend.models;

import com.ts.core.entities.IEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "message_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDetails extends IEntity {

    @ManyToOne
    private Message ownerMessage;

    @Column(name = "text")
    private String text;
}
