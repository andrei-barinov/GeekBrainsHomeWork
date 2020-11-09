import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Server {
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket clientSocket;

    public Server(){
        try{
            System.out.println("Сервер включается...");
            serverSocket = new ServerSocket(7777);
            System.out.println("Сервер ожидает подключения...");
            clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился " + clientSocket);

            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            AtomicBoolean isDrop = new AtomicBoolean(false);


            new Thread(() ->{
                try {
                    while (true) {
                        String IncomingMessage = in.readUTF();
                        if (IncomingMessage.contains("-exit")) {
                            System.out.println("Клиент отключился(((");
                            out.writeUTF("-exit");
                            break;
                        }
                        System.out.println(IncomingMessage);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }).start();

            Scanner sc = new Scanner(System.in);
            while (true){
                if(isDrop.get()){
                    System.out.println("Соединение закрывается...");
                    break;
                }
                //System.out.println("Пожалуйста введите сообщение: ");
                out.writeUTF("Сервер: " + sc.nextLine());
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private void closeConnection(){
        try{
            serverSocket.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        try{
            clientSocket.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        try{
            in.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        try{
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}