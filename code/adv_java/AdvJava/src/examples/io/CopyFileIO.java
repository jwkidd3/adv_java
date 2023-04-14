package examples.io;

import java.io.*;

public class CopyFileIO {

  public static void main(String[] args) {
    File original = new File("/Users/jwkidd3/Downloads/flight-2021-11-15 15_06_12-Side.mp4");
    File copy = new File("/tmp/flight-2021-11-15 15_06_12-Side_copy.mp4");
    int fileLength = (int) original.length();
    InputStream originalStream = null;
    OutputStream copyStream = null;

    try {
      originalStream = new FileInputStream(original);
      copyStream = new FileOutputStream(copy);
      byte [] contents = new byte[fileLength];
      originalStream.read(contents);
      copyStream.write(contents);
    } catch(IOException ioe) {
      ioe.printStackTrace();
    } finally {
      try{
        originalStream.close();
      } catch(IOException ioe) {}
      try{
        copyStream.close();
      } catch(IOException ioe) {}
    }
  }
}
