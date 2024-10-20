package day6ws;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import day6ws.ClientHandler;

public class Server {

    public static void main(String[] args) throws IOException{
        int port = 12345;

        ServerSocket server = new ServerSocket(port);

        System.out.println("Listening on port" + port);
        


        ExecutorService executor = Executors.newFixedThreadPool(3);
        while (true) {
            Socket socket = server.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            executor.submit(clientHandler);

            
        }
    
}
}
