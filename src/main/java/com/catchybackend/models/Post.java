package com.catchybackend.models;

import com.ts.core.entities.IEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "post")
public class Post extends IEntity {
    private String postHeader;
    private String postBody;

}
