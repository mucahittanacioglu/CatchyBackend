package com.catchybackend.dataaccess;

import com.catchybackend.models.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMessageRepository extends JpaRepository<Conversation,Long> {
        List<Conversation> findAllByOwner(long userId);
}