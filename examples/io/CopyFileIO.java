package examples.io;

import java.io.*;

public class CopyFileIO {

  public static void main(String[] args) {
    File original = new File("/tmp/pic.jpg");
    File copy = new File("/tmp/pic_copy.jpg");
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
