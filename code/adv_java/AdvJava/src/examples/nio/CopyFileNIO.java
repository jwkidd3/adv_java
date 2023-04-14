package examples.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFileNIO {

  public static void main(String[] args) throws IOException {
    File readFile = new File("/Users/jwkidd3/Downloads/flight-2021-11-15 15_06_12-Side.mp4");
    File writeFile = new File("/tmp/flight-2021-11-15 15_06_12-Side_copy.mp4");

    ByteBuffer fileBuffer = ByteBuffer.allocate(256);

    FileInputStream fis = new FileInputStream(readFile);
    FileChannel origChannel = fis.getChannel();
    FileOutputStream fos = new FileOutputStream(writeFile);
    FileChannel copyChannel = fos.getChannel();

    int bytesRead = origChannel.read(fileBuffer);
    while(bytesRead != -1) {
      fileBuffer.flip();
      copyChannel.write(fileBuffer);
      fileBuffer.clear();
      bytesRead = origChannel.read(fileBuffer);
    }

    copyChannel.close();
    origChannel.close();
    fos.close();
    fis.close();
  }
}
