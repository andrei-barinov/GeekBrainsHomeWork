package com.chat;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClientApp {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7777);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            AtomicBoolean isDrop = new AtomicBoolean(false);

            ExecutorService executorService = Executors.newFixedThreadPool(1);

            executorService.execute(new Thread(() ->{
                try {
                    while (true){
                        String message = in.readUTF();
                        if(message.equals("-exit")){
                            isDrop.set(true);
                            break;
                        }
                        System.out.println(message);
                    }
                    System.out.println("Для завершения работы нажмите Enter");
                    executorService.shutdown();
                } catch (IOException e){
                    throw new RuntimeException("Что-то пошло не так", e);
                }

            }));

            if(!isDrop.get()){
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    while (true){
                        //System.out.println("----------");
                        out.writeUTF(reader.readLine());
                        if(isDrop.get()){
                            break;
                        }
                    }
                } catch (IOException e){
                    throw new RuntimeException("Что-то пошло не так", e);
                }
            } else return;
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
