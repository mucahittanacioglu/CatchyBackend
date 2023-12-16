package com.catchybackend.controller;

import com.catchybackend.business.interfaces.IConversationService;
import com.catchybackend.models.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversation")
@CrossOrigin(origins = "http://localhost:5173")
public class MessageController {
    @Autowired
    IConversationService conversationService;
    @GetMapping("/findMessages")
    public ResponseEntity<List<Conversation>> deletePost(@RequestParam(name = "id") long id){
        return ResponseEntity.ok(this.conversationService.findAllByUserId(id));
    }
    @PostMapping("/createConversation")
    public ResponseEntity<Conversation> createConversation(@RequestParam(name="starterId")long starterId,@RequestParam(name="receiverId")long receiverId){
        return ResponseEntity.ok(conversationService.createConversation(starterId,receiverId));
    }
//TODO: İnterfaceler üzerinden bağımlılık oluştur.
}
