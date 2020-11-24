package com.chat.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBService {
    private DBService(){};

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users",
                    "root",
                    "root");
        } catch (SQLException e){
            throw new RuntimeException("Что-то пошло не так при установке соединения с БД", e);
        }
    }

    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("Что-то пошло не так", e);
        }
    }
}

