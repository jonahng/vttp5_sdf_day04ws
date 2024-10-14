import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.io.*;


public class ClientMain {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("localhost", 3000);
        System.out.printf(">>>> connected to server");


        Console cons = System.console();
        String msg = cons.readLine("Type words here >");
        msg = msg + "\n";


        //output stream
        OutputStream os = sock.getOutputStream();
        Writer writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);

        //input stream
        InputStream is = sock.getInputStream();
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        bw.write(msg + "\n");
        bw.flush();

        msg = br.readLine();
        System.out.printf("From server: %s \n", msg);






        //writing message to server, converting the message into bytes
        //flush means to send it to the network




        sock.close();
        


    }
}
