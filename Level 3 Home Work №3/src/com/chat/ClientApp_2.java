package com.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp_2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7777);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(() ->{
                try {
                    while (true){
                        String message = in.readUTF();
                        System.out.println(message);
                    }
                } catch (IOException e){
                    throw new RuntimeException("Что-то пошло не так", e);
                }
            }).start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                try {
                    while (true){
                        //System.out.println("----------");
                        out.writeUTF(reader.readLine());
                    }
                } catch (IOException e){
                    throw new RuntimeException("Что-то пошло не так", e);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
