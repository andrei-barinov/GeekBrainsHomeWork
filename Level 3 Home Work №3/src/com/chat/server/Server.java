package com.chat.server;

import com.chat.auth.AuthenticationService;

public interface Server {
    void broadcastMessage(String message);
    boolean isLoggedIn(String nickname);
    void subscribe(ClientHandler client);
    void unsubscribe(ClientHandler client);
    void sendMessageToClient(String message);
    void doFileWriter(String message);
    void printHistory (String message, ClientHandler client);
    void entrIsTrue(String message);
    void outFromApp(String message);
    AuthenticationService getAuthenticationService();
}
