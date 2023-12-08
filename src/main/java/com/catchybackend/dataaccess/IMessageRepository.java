package com.catchybackend.dataaccess;

import com.catchybackend.models.Message;
import com.catchybackend.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMessageRepository extends JpaRepository<Message,Long> {
        List<Message> findAllByOwner(long userId);
}