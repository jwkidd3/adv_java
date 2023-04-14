package examples.nio.async;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class Server {

  public static void main(String[] args) {
    LinkedBlockingQueue<SocketChannel> readyQueue =
            new LinkedBlockingQueue<SocketChannel>();


    ServerSocketThread serverSocketProcessor = new ServerSocketThread(readyQueue);
    try {
      serverSocketProcessor.prepareAndInitializeChannel();
    } catch (IOException e) {
      e.printStackTrace();
    }
    Thread selectorThread = new Thread(serverSocketProcessor);
    selectorThread.start();

    RequestProcessor clientProcessor = new RequestProcessor(readyQueue);
    Thread processorThread = new Thread(clientProcessor);
    processorThread.start();
  }

}
