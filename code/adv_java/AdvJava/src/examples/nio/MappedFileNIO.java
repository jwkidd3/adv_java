package examples.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedFileNIO {

  public static void main(String[] args) throws IOException {
    File readFile = new File(args[0]);
    File writeFile = new File("/tmp/" + args[1]);


    FileInputStream fis = new FileInputStream(readFile);
    FileChannel origChannel = fis.getChannel();
    MappedByteBuffer mappedBuffer = origChannel.map(FileChannel.MapMode.READ_ONLY, 0, origChannel.size());

    try {
      Thread.sleep(10000);
    } catch (Exception e) {}

    FileOutputStream fos = new FileOutputStream(writeFile);
    FileChannel copyChannel = fos.getChannel();
    copyChannel.write(mappedBuffer);


    copyChannel.close();
    origChannel.close();
    fos.close();
    fis.close();
  }
}