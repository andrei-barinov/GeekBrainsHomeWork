package com.chat.server;

import com.chat.auth.AuthenticationService;
import com.chat.auth.BasicAuthenticationService;
import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ChatServer implements Server {
    private static final Logger logger = Logger.getLogger(ChatServer.class.getName());
    private Set<ClientHandler> clients;
    private AuthenticationService authenticationService;

    public ChatServer(){
        try{
            System.out.println("Сервер запускается...");
            logger.info("Сервер запускается...");
            ServerSocket serverSocket = new ServerSocket(7777);
            clients = new HashSet<>();
            authenticationService = new BasicAuthenticationService();
            System.out.println("Сервер успешно запущен");
            logger.info("Сервер успешно запущен");

            while (true){
                System.out.println("Сервер ождидает подключения клиента...");
                logger.info("Сервер ождидает подключения клиента...");
                Socket socket = serverSocket.accept();
                System.out.println("Клиент успешно подключился. Сокет: " + socket);
                logger.info("Клиент успешно подключился. Сокет: " + socket);
                new ClientHandler(this, socket);
            }
        } catch (IOException e){
            logger.error("Выброс исключения", e);
            throw new RuntimeException("Что-то пошло не так", e);
        }
    }

    @Override
    public void broadcastMessage(String message) {
        String[] inputMessage = message.split("\\s");
        String nickname = inputMessage[0].substring(0, inputMessage[0].length()-1);
        Date date = new Date();
        logger.info("Клиент " + nickname + " прислал сообщение: " + message);
        message = date + " " + message;
        for(ClientHandler client: clients){
            /*if(client.getName().equals(nickname)){
                continue;
            }
            else */
                client.sendMessage(message);
        }
        //doFileWriter(message);
    }

    public void entrIsTrue(String message) {
        String[] inputMessage = message.split("\\s");
        String nickname = inputMessage[1].substring(0, inputMessage[1].length()-1);
        for(ClientHandler client: clients){
            if(client.getName().equals(nickname)){
                continue;
            }
            else client.sendMessage(message);
        }
    }

    public void outIsTrue(String message) {
        String[] inputMessage = message.split("\\s");
        String nickname = inputMessage[0];
        message = inputMessage[1];
        for(ClientHandler client: clients){
            if(client.getName().equals(nickname)){
                client.sendMessage(message);
            }
            else continue;
        }
    }

    @Override
    public void sendMessageToClient(String message){
        Date date = new Date();
            String[] inputMessage = message.split("\\s");
            String ourClient = inputMessage[2];
            String newMessage = "";
            for(int i=3; i < inputMessage.length; i++){
                newMessage += inputMessage[i] + " ";
            }
            logger.info("Клиент " + inputMessage[0] + " отправил сообщение клиенту " + ourClient + "\n"
                    + "Сообщение: " + newMessage);
            newMessage = inputMessage[2] + ": " + newMessage;
            newMessage = date + " " + newMessage;
            for(ClientHandler client: clients){
                if(ourClient.equals(client.getName())){
                    client.sendMessage(newMessage);
                }
            }
            //doFileWriter(newMessage);
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
        logger.info("Клиент " + client.getName() + " авторизовался");
    }

    @Override
    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        logger.info("Клиент " + client.getName() + " вышел из чата");
    }

    @Override
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

   /* public void doFileWriter(String message){
        try {
            BufferedWriter bw = new BufferedWriter(
              new FileWriter(
                      new File("/Users/barinovaa/Desktop/IDEA/Projects/Level 2 Home Work №7/src/com/chat" +
                              "/history/history.txt"),
                              true
              )
            );

            bw.newLine();
            bw.write(message);
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printHistory (String message, ClientHandler client){
                client.sendMessage(message);
    }*/
}
