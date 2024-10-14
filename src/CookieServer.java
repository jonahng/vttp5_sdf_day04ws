import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class CookieServer{

    public static void main(String[] args) throws IOException{
        int port = 12345;

        ServerSocket server = new ServerSocket(port);
        System.out.println("Listening on port" + port);
        Socket socket = server.accept();
        while(true){
            if(socket.isConnected()){
                System.out.println("Client has connected to this server!");


                InputStream is = socket.getInputStream();
                Reader reader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(reader);

                OutputStream os = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(writer);

                String message = "This is a text message 123 \n";

                bw.write(message);
                bw.flush();
                socket.close();



                
            }


        }
       




    }

    

}