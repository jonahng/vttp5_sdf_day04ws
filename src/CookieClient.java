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

        String messageFromServer = br.readLine();
        System.out.println("The message from the server is " + messageFromServer);

        
    }
    
    
}
