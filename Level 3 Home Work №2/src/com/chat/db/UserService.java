package com.chat.db;

import com.chat.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class UserService implements Service<User>{
    @Override
    public User getUser(String email, String password) {
        Connection connection = DBService.getConnection();

        try{
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
                    return user;
                } else {
                    return null;
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Что-то пошло не так", e);
        } finally {
            DBService.close(connection);
        }
        return null;
    }
}
