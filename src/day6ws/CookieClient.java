package day6ws;

import java.net.*;
import java.util.*;
import java.io.*;


public class CookieClient{

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",12345);
        if(socket.isConnected()){
            System.out.println("Connected to the socket/server!");
        }

        OutputStream os = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);


        InputStream is = socket.getInputStream();
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        Console console = System.console();
        String keyboardInput = "";
       
        while(!keyboardInput.contains("close")){
            keyboardInput = console.readLine("either type get-cookie to get message, or close to close app.");
            bw.write(keyboardInput + "\n");
            bw.flush();
            System.out.println("your message following message was sent: " + keyboardInput);
    
            String messageFromServer = br.readLine();
            System.out.println("The message from the server is " + messageFromServer);
        }
        




        

        
    }
    
    
}
