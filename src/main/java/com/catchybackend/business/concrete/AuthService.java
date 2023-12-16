package com.catchybackend.business.concrete;

import com.catchybackend.business.dtos.UserLoginDto;
import com.catchybackend.business.interfaces.IUserService;
import com.catchybackend.dataaccess.UserRepository;
import com.catchybackend.models.User;
import com.ts.core.security.Role;
import com.ts.core.security.jwt.IJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IJwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity<String> login(UserLoginDto userLoginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword()));
        var tempUser = userRepository.getUserByEmail(userLoginDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        var user = new org.springframework.security.core.userdetails.User(
                tempUser.getEmail(), tempUser.getPassword(), new ArrayList<>()
        );
        var jwt = jwtService.generateToken(user);
        return ResponseEntity.ok().body(jwt);
    }

    @Override
    public ResponseEntity<String> register(User user) {
        var userS = org.springframework.security.core.userdetails.User.builder().username(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword())).build();

        var userToSave = new User();

        userToSave.setFirstName(user.getFirstName());
        userToSave.setLastName(user.getLastName());
        userToSave.setEmail(user.getEmail());
        userToSave.setPassword(passwordEncoder.encode(user.getPassword()));
        userToSave.setRoles(new HashSet<>());
        userToSave.addRole(Role.ADD);
        userToSave.addRole(Role.UPDATE);

        userRepository.save(userToSave);
        var jwt = jwtService.generateToken(userS);
        return ResponseEntity.ok().body(jwt);

    }

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

    public String update(User user) {
        return userRepository.save(user).toString();
    }
}
