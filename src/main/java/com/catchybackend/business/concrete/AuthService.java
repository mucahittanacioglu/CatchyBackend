package com.catchybackend.business.concrete;

import com.catchybackend.business.dtos.UserLoginDto;
import com.catchybackend.business.interfaces.IAuthService;
import com.catchybackend.business.interfaces.IUserService;
import com.catchybackend.dataaccess.UserRepository;
import com.catchybackend.models.User;
import com.ts.core.security.Role;
import com.ts.core.security.jwt.IJwtService;
import com.ts.core.security.jwt.MyUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
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

        var user = new MyUserDetails(
                tempUser.getEmail(), tempUser.getPassword(), new ArrayList<>(),tempUser.getId()
        );
        var jwt = jwtService.generateToken(user);
        return ResponseEntity.ok().body(jwt);
    }

    @Override
    public ResponseEntity<String> register(User user) {
        var userS = new MyUserDetails(
                user.getEmail(), passwordEncoder.encode(user.getPassword()), new ArrayList<>(),-1l
        );
        var userToSave = new User();

        userToSave.setFirstName(user.getFirstName());
        userToSave.setLastName(user.getLastName());
        userToSave.setEmail(user.getEmail());
        userToSave.setPassword(passwordEncoder.encode(user.getPassword()));
        userToSave.setRoles(new HashSet<>());
        userToSave.addRole(Role.ADD);
        userToSave.addRole(Role.UPDATE);

        var savedUser = userRepository.save(userToSave);
        userS.setUserId(savedUser.getId());
        var jwt = jwtService.generateToken(userS);
        return ResponseEntity.ok().body(jwt);

    }

}
