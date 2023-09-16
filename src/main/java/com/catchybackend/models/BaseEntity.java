package com.catchybackend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@MappedSuperclass
@Data
@EntityListeners(EntityUpdateListener.class)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date createdAt= Calendar.getInstance().getTime();
    @Column
    private Date updatedAt=  Calendar.getInstance().getTime();
}
