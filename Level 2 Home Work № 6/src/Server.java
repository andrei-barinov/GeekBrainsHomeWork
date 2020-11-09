import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
            System.out.println("Клиен подключился " + clientSocket);

            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            while (true){
                String IncomingMessage = in.readUTF();
                if(IncomingMessage.contains("-exit")){
                    out.writeUTF("cmd Exit");
                    break;
                }
                out.writeUTF("Echo: " + IncomingMessage);
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


