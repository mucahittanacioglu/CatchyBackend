package com.catchybackend.dataaccess;

import com.catchybackend.models.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IConversationRepository extends JpaRepository<Conversation,Long> {
    List<Conversation> findAllByParticipantsContains(Long id);
}