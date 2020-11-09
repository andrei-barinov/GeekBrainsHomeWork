import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client(){
        try{
            System.out.println("Сокет запускается...");
            Socket socket = new Socket("localhost", 7777);
            System.out.println(socket);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            AtomicBoolean isDrop = new AtomicBoolean(false);

            new Thread(() ->{
                try {
                    while (true) {
                        String IncomingMessage = in.readUTF();
                        if (IncomingMessage.contains("-exit")) {
                            System.out.println("Нажмите Enter для закрытия командной строки...");
                            isDrop.set(true);
                            break;
                        }
                        System.out.println(IncomingMessage);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }).start();

            Scanner sc = new Scanner(System.in);
            /*String input = sc.nextLine();
            String exit = "-exit";
            if(input.equals(exit)){
                isDrop.set(true);
            }*/
            while (true){
                if(isDrop.get()){
                    System.out.println("Соединение закрывается...");
                    break;
                }
                //System.out.println("Клиент, пожалуйста введите сообщение: ");
                out.writeUTF("Клиент: " + sc.nextLine());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client socket = new Client();
    }

}