
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadUsingBuffering {

    public static void main(String []args) throws FileNotFoundException, IOException{
        
        FileInputStream fis = new FileInputStream("hamlet.txt");
        
        int cnt = 0;
        int b;
        byte []buffer = new byte[1024];
        
        long startTime = System.nanoTime();

        while ((b = fis.read(buffer)) != -1) {
             cnt++;
        }
        
        long endTime = System.nanoTime();
        
        System.out.println("Number of reads : " + cnt);
        System.out.println("2. Time taken to read: " + (endTime - startTime) + " nano seconds..");
    }
}
