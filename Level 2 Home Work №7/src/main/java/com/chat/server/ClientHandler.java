package com.chat.server;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientHandler {
    private com.chat.server.Server server;
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
                AtomicBoolean isAuth = new AtomicBoolean(false);
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
                                            server.entrIsTrue(name + " вошел в чат");
                                            server.subscribe(this);
                                            isAuth.set(true);
                                            //server.printHistory(doFileReader(), this);
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
                if(isAuth.get()){
                    break;
                }
            }
        }catch (IOException e){
            throw new RuntimeException("Что-то пошло не так", e);
        }
    }

    private void receiveMessage(){
        try {
            Date date = new Date();
            while (true){
                String message = in.readUTF();
                if(message.equals("-exit")){
                    server.outIsTrue(name + " " + message);
                    server.unsubscribe(this);
                    server.broadcastMessage(name + " вышел из чата");
                    return;
                }
                else if(message.startsWith("/w")){
                    server.sendMessageToClient(name + ": " + message);
                }
                else server.broadcastMessage(name + ": " + message);
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

    public void closeConnection(){
        server.unsubscribe(this);
        server.broadcastMessage(name + " вышел из чата");
        try {
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            in.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    /*public String doFileReader(){
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(
                            new File("/Users/barinovaa/Desktop/IDEA/Projects/Level 2 Home Work №7/src/com/chat" +
                                    "/history/history.txt")
                    )
            );

            String message = "";
            ArrayList<String> arr = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null){
                arr.add(line);
            }
            if(arr.size() <= 100){
                for(String str: arr){
                    message += str + "\n";
                }
                return message;
            }
            else {
                int a = arr.size();
                int b = a - 100;
                for(int i = b - 1; i <= b + 100 - 1; i++){
                    message += arr.get(i) + "\n";
                }
                return message;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }*/
}


