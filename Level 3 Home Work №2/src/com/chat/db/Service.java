package com.chat.db;

public interface Service<T> {
    T getUser(String email, String password);
}
