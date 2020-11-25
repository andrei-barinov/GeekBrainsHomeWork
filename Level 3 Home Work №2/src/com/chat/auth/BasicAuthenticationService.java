package com.chat.auth;

import com.chat.db.UserService;
import com.chat.entity.User;
import com.chat.db.DBService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService {


    @Override
    public Optional<User> doAuth(String email, String password) {
        UserService userService = new UserService();
        return Optional.of(userService.getUser(email, password));
    }

}
