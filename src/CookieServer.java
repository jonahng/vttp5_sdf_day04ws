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

        String clientInput = "";
        while(true){
            
            if(socket.isConnected()){
                System.out.println("Client has connected to this server!");


                InputStream is = socket.getInputStream();
                Reader reader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(reader);
                


                OutputStream os = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(writer);

                System.out.println("Server is listening...");


                clientInput = br.readLine();
                System.out.println("input received:" + clientInput);
                Cookie cookie = new Cookie();

                

                if(clientInput.contains("get-cookie")){

                    String cookie_text = cookie.getCookieText();
                    bw.write(cookie_text + "\n");
                    System.out.println("sending the following message to client:" + cookie_text);
                    bw.flush();
                }

                if(clientInput.contains("close")){
                    bw.write("You have closed the server, server going offline. BYEEEE \n");
                    bw.flush();
                    break;
                }

                
                
                
            }

        }
        System.out.println("closing server and socket");
        socket.close();
       




    }

    

}