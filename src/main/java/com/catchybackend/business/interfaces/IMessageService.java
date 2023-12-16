package com.catchybackend.business.interfaces;

import com.catchybackend.models.Conversation;

import java.util.List;

public interface IMessageService {
    List<Conversation> findAllByUserId(Long id);

}
