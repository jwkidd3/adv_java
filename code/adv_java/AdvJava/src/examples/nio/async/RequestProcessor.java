package examples.nio.async;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class RequestProcessor implements Runnable {

  LinkedBlockingQueue<SocketChannel> queue;
  ByteBuffer channelBuffer;

  public RequestProcessor(LinkedBlockingQueue<SocketChannel> q) {
    queue = q;
    channelBuffer = ByteBuffer.allocate(256);
  }

  public void run() {
    while(true) {
      System.out.println("processing socket");
      SocketChannel socketChannel = null;
      try {
        socketChannel = queue.take();
        int bytesRead = socketChannel.read(channelBuffer);

        channelBuffer.flip();
        if (bytesRead == -1) {
          socketChannel.close();
        } else {
          socketChannel.write(channelBuffer);
        }

        channelBuffer.clear();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (IOException e) {
        System.out.println("exception: " + e);
      }
    }

  }
}
