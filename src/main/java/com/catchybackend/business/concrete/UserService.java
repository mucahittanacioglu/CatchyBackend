package com.catchybackend.business.concrete;

import com.catchybackend.business.interfaces.IAuthService;
import com.catchybackend.business.interfaces.IUserService;
import com.catchybackend.dataaccess.UserRepository;
import com.catchybackend.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    @Override
    public ResponseEntity<Boolean> addFriend(Long userId, Long friendId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isPresent()){
            Optional<User> friendOpt = userRepository.findById(friendId);
            if(friendOpt.isPresent()){
                User usr = userOpt.get();
                User frnd = friendOpt.get();
                usr.getFriends().add(frnd);
                frnd.getFriends().add(usr);

                userRepository.save(usr);
                userRepository.save(frnd);
                return ResponseEntity.ok(true);
            }

            return ResponseEntity.ok(false);
        }else{
            //TODO:Hata dönmeli
            return ResponseEntity.ok(false);
        }
    }

    @Override
    public ResponseEntity<List<User>> getFriends(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.isPresent()){
            return ResponseEntity.ok(userOpt.get().getFriends());
        }else{
            //TODO:Hata dönmeli
            return ResponseEntity.ok(new ArrayList<>());
        }

    }

    public ResponseEntity<String> update(User user) {
        return ResponseEntity.ok(userRepository.save(user).toString());
    }
}