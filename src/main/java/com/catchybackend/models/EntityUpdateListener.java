package com.catchybackend.models;


import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;
import java.util.Calendar;

public class EntityUpdateListener {

    @PreUpdate
    public void beforeUpdate(BaseEntity entity) {
        // Update the updatedAt field with the current date and time before the entity is updated.
        entity.setUpdatedAt(Calendar.getInstance().getTime());
    }
}