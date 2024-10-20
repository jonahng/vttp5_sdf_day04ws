package day6ws;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import day6ws.ClientHandler2;

public class Server2 {

    public static void main(String[] args) throws IOException{
        int port = 12345;

        ServerSocket server = new ServerSocket(port);

        System.out.println("Listening on port" + port);
        


        ExecutorService executor = Executors.newFixedThreadPool(2);
        while (true) {
            Socket socket = server.accept();
            ClientHandler2 clientHandler = new ClientHandler2(socket);
            executor.submit(clientHandler);

            
        }
    
}
}
