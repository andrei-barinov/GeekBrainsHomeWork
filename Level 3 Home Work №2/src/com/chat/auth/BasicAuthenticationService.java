package com.chat.auth;

import com.chat.entity.User;
import com.chat.db.DBService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService {


    @Override
    public Optional<User> doAuth(String email, String password) {

        Connection connection = DBService.getConnection();

        try{
            connection.createStatement();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM data WHERE mail = ? AND password = ?"
            );
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            Collection<User> list = new ArrayList<>();
            while (resultSet.next()){
                list.add(
                        new User(
                        resultSet.getString("nickname"),
                        resultSet.getString("email"),
                        resultSet.getString("password")));
            }
            for(User user: list){
                if(user != null){
                    return Optional.of(user);
                } else {
                    return Optional.empty();
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Что-то пошло не так", e);
        } finally {
            DBService.close(connection);
        }
        return Optional.empty();
    }

}
