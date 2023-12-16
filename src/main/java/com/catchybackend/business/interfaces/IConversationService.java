package com.catchybackend.business.interfaces;

import com.catchybackend.models.Conversation;

import java.util.List;

public interface IConversationService {
    List<Conversation> findAllByUserId(Long id);
    Conversation createConversation(Long starterId, Long receiverId);

}
