package com.chat.auth;

import com.chat.entity.User;

import java.util.List;
import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService {

    @Override
    public Optional<User> doAuth(String email, String password) {

        UserRepository userRepository = new UserRepository();

        return userRepository.findUserByEmailAndPassword(email, password);
    }
}
