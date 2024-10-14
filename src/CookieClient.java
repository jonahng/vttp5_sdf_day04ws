import java.net.*;
import java.util.*;
import java.io.*;


public class CookieClient{

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",12345);
        if(socket.isConnected()){
            System.out.println("Connected to the socket/server!");
            

        }
        
        
    }
    
    
}
