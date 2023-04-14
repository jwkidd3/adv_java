
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadOneCharacterAtATime {

    public static void main(String []args) throws FileNotFoundException, IOException{
        
        FileInputStream fis = new FileInputStream("hamlet.txt");
        
        int cnt = 0;
        int b;
        
        long startTime = System.nanoTime();

        while ((b = fis.read()) != -1) {
             cnt++;
        }
        
        long endTime = System.nanoTime();
        
        System.out.println("Number of reads : " + cnt);
        System.out.println("1. Time taken to read: " + (endTime - startTime) + " nano seconds..");
    }
}
