import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class ServerMain{
    public static void main(String[] args) throws IOException{

        int port = 3000;
        if (args.length >0){
            port = Integer.parseInt(args[0]);
        }
        System.out.printf(">>Listening on port %d\n" ,port);

        ServerSocket server = new ServerSocket(port);

        

        while(true){
            
        System.out.println("Waiting for connect");

        Socket conn = server.accept();

        System.out.println("Client connected");


        //getting input stream from client
        InputStream is = conn.getInputStream();
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        OutputStream os = conn.getOutputStream();
        Writer writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);

        String msg = br.readLine();
        System.out.printf("Message from client : %s \n",msg);
        msg = msg.toUpperCase() + "\n";
        bw.write(msg);
        bw.flush();
        conn.close();


        }
        
        
    }
}

