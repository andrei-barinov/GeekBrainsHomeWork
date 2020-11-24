package com.chat.server;

import com.chat.auth.AuthenticationService;
import com.chat.auth.BasicAuthenticationService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer implements Server {

    private Set<ClientHandler> clients;
    private AuthenticationService authenticationService;

    public ChatServer(){
        try{
            System.out.println("Сервер запускается...");
            ServerSocket serverSocket = new ServerSocket(7777);
            clients = new HashSet<>();
            authenticationService = new BasicAuthenticationService();
            System.out.println("Сервер успешно запущен");

            while (true){
                System.out.println("Сервер ождидает подключения клиента...");
                Socket socket = serverSocket.accept();
                System.out.println("Клиент успешно подключился. Сокет: " + socket);
                new ClientHandler(this, socket);
            }
        } catch (IOException e){
            throw new RuntimeException("Что-то пошло не так", e);
        }
    }

    @Override
    public void broadcastMessage(String message) {
        String[] inputMessage = message.split("\\s");
        String ourClient = inputMessage[0].substring(0, inputMessage[0].length()-1);
        clients.forEach(client -> {
            if(!ourClient.equals(client.getName())){
                client.sendMessage(message);
            }
        });
    }

    @Override
    public void sendMsgToClient(String message){
        String[] inputMessage = message.split("\\s");
        String ourClient = inputMessage[2];
        String newMessage = "";
        for(int i=3; i < inputMessage.length; i++){
            newMessage += inputMessage[i] + " ";
        }
        newMessage = inputMessage[0].substring(0, inputMessage[0].length()-1) + ": " + newMessage;
        for(ClientHandler client: clients){
            if(ourClient.equals(client.getName())){
                client.sendMessage(newMessage);
            }
        }
    }

    @Override
    public synchronized boolean isLoggedIn(String nickname) {
        return clients.stream()
                .filter(clientHandler -> clientHandler.getName().equals(nickname))
                .findFirst()
                .isPresent();
    }

    @Override
    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    @Override
    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    @Override
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }


}
