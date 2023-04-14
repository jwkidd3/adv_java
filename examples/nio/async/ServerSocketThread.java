package examples.nio.async;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class ServerSocketThread implements Runnable {

  private Selector selector;
  private SelectionKey serverSocketKey;
  private LinkedBlockingQueue<SocketChannel> queue;

  public ServerSocketThread(LinkedBlockingQueue<SocketChannel> q) {
    queue = q;
  }

  public void prepareAndInitializeChannel() throws IOException {
    ServerSocketChannel channel = ServerSocketChannel.open();
    channel.configureBlocking(false);
    ServerSocket ss = channel.socket();
    InetSocketAddress socketAddress = new InetSocketAddress(9001);
    ss.bind(socketAddress);
    this.selector = Selector.open();
    serverSocketKey = channel.register(selector, SelectionKey.OP_ACCEPT);
  }

  public void run() {
    System.out.println("Server ready for connections...");
    while(true) {
      try {
        int keyCount = selector.select();
        if(keyCount == 0) {
          continue;
        }

        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
        while (keyIterator.hasNext()) {
          SelectionKey tmpKey = keyIterator.next();
          handleKey(tmpKey);
          keyIterator.remove();
        }

      } catch(IOException ioe) {
        ioe.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void handleKey(SelectionKey tmpKey) throws IOException, InterruptedException {

    if (tmpKey == serverSocketKey && tmpKey.isAcceptable()) {    
      ServerSocketChannel channel = (ServerSocketChannel) tmpKey.channel();
      SocketChannel socketChannel = channel.accept();
      socketChannel.configureBlocking(false);
      socketChannel.register(selector, SelectionKey.OP_READ);
    } else {
      if (tmpKey.isValid()) {
        queue.put((SocketChannel) tmpKey.channel());
        System.out.println("Socket ready for processing");
      } else if(!tmpKey.isValid()) {
        tmpKey.channel().close();
        tmpKey.cancel();       
      }
    }
  }
}



