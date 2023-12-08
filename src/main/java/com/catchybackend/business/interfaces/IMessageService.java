package com.catchybackend.business.interfaces;

import com.catchybackend.models.Message;

import java.util.List;

public interface IMessageService {
    List<Message> findAllByUserId(Long id);

}
