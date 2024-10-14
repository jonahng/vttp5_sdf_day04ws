import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class CookieServer{

    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(12345);
        Socket socket = server.accept();
        if(socket.isConnected()){
            System.out.println("Client has connected to this server!");
        }




    }

    

}