package com.chat.auth;

import com.chat.db.DataSource;
import com.chat.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepository {
    public Optional<User> findUserByEmailAndPassword(String email, String password){
        Connection connection = DataSource.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM data WHERE email = ? AND password = ?"
            );
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                 return Optional.of(new User(
                        rs.getString("nickname"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }
}
