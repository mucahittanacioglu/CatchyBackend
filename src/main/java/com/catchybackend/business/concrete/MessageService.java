package com.catchybackend.business.concrete;

import com.catchybackend.business.interfaces.IMessageService;
import com.catchybackend.dataaccess.IMessageRepository;
import com.catchybackend.models.Conversation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MessageService implements IMessageService {
    @Autowired
    IMessageRepository messageRepository;
    @Override
    public List<Conversation> findAllByUserId(Long id) {
        return this.messageRepository.findAllByOwner(id);
    }

}
