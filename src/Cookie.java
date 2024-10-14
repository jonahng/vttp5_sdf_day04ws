import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Cookie {
    public String getCookieText() throws IOException{
        Random random = new Random();

        int randomLine = random.nextInt(9);
        
        
        File file = new File("C:\\Users\\65932\\vttp5_sdf_day04ws\\cookie_file.txt");
        String cookieText = Files.readAllLines(Paths.get("C:\\Users\\65932\\vttp5_sdf_day04ws\\cookie_file.txt")).get(randomLine);
        return cookieText;



    }
    public void main(String[] args) throws IOException {
        System.out.println(getCookieText());
        
    }
    
}
