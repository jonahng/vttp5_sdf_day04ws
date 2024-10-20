package day6ws;
import java.io.*;
import java.net.*;
import day6ws.Cookie3;



public class ClientHandler2 implements Runnable{
    private Socket socket;
    public Cookie3 cookie = new Cookie3();

    public ClientHandler2(Socket socket){
        this.socket = socket;
    }

    public void run() {
        String clientInput = "";
        while (!clientInput.contains("close server")) {
            
        
        try {

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
            
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("IO Exception i think");
        }
    }
        



    }
}
