package com.catchybackend.controller;

import com.catchybackend.business.interfaces.IMessageService;
import com.catchybackend.models.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    IMessageService messageService;
    @GetMapping("/findMessages")
    public ResponseEntity<List<Conversation>> deletePost(@RequestParam(name = "id") long id){
        return ResponseEntity.ok(this.messageService.findAllByUserId(id));
    }
//TODO: İnterfaceler üzerinden bağımlılık oluştur.
}
