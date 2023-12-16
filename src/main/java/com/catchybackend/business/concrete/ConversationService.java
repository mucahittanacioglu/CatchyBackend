package com.catchybackend.business.concrete;

import com.catchybackend.business.interfaces.IConversationService;
import com.catchybackend.dataaccess.IConversationRepository;
import com.catchybackend.dataaccess.UserRepository;
import com.catchybackend.models.Conversation;
import com.catchybackend.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConversationService implements IConversationService {

    private final IConversationRepository conversationRepository;
    private final UserRepository userRepository;
    @Override
    public List<Conversation> findAllByUserId(Long id) {
        return this.conversationRepository.findAllByParticipantsContains(id);
    }

    @Override
    public Conversation createConversation(Long starterId, Long receiverId) {
        Conversation conv = new Conversation();
        conv.setParticipants(new HashSet<>());
        Optional<User> starter = userRepository.findById(starterId);
        Optional<User> receiver = userRepository.findById(receiverId);

        if(starter.isPresent()){
            conv.getParticipants().add(starter.get());
        }

        if(receiver.isPresent()){
            conv.getParticipants().add(receiver.get());
        }
        return conversationRepository.save(conv);
    }
}
