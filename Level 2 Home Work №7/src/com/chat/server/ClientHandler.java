package com.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            doListen();

        } catch (IOException e){
            throw new RuntimeException("Что-то пошло не так", e);
        }
    }

    public String getName() {
        return name;
    }

    private void doListen(){
        new Thread(() ->{
            try{
                doAuth();
                receiveMessage();
            } catch (Exception e){
                throw new RuntimeException("Что-то пошло не так", e);
            } finally {
                server.unsubscribe(this);
            }
        }).start();
    }

    private void doAuth(){
        try {
            while (true){
                String credentials = in.readUTF();
                /**
                 * "-auth n1@email.com 1"
                 */
                if(credentials.startsWith("-auth")){
                    /**
                     * После сплитинга получим массив:
                     * ["-auth", "n1@mail.com", "1"]
                     */
                    String[] credentialValues = credentials.split("\\s");
                    server.getAuthenticationService()
                            .doAuth(credentialValues[1], credentialValues[2])
                            .ifPresentOrElse(
                                    user ->  {
                                        if(!server.isLoggedIn(user.getNickname())) {
                                            sendMessage("Аутентификация прошла успешно");
                                            name = user.getNickname();
                                            server.broadcastMessage(name + " вошел в чат");
                                            server.subscribe(this);
                                        }else {
                                            sendMessage("Текущий пользователь уже зарегистрирован");
                                        }
                                    },
                                    new Runnable(){
                                        @Override
                                        public void run() {
                                            sendMessage("Не найден пользователь с таким email и паролем");
                                        }
                                    }
                            );
                }
            }
        }catch (IOException e){
            throw new RuntimeException("Что-то пошло не так", e);
        }
    }

    private void receiveMessage(){
        try {
            while (true){
                String message = in.readUTF();
                if(message.equals("-exit")){
                    return;
                }
                server.broadcastMessage(message);
            }
        } catch (IOException e){
            throw new RuntimeException("Что-то пошло не так", e);
        }
    }

    public void sendMessage(String message){
        try {
            out.writeUTF(message);
        } catch (IOException e){
            throw new RuntimeException("Что-то пошло не так", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientHandler that = (ClientHandler) o;
        return Objects.equals(server, that.server) &&
                Objects.equals(socket, that.socket) &&
                Objects.equals(in, that.in) &&
                Objects.equals(out, that.out) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, socket, in, out, name);
    }
}


