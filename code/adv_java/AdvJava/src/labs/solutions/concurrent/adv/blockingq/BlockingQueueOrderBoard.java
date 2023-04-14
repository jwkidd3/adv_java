package labs.solutions.concurrent.adv.blockingq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * An implementation of OrderBoard using
 * a BlockingQueue.
 * 
 * @author developintelligence llc
 * @version 1.0
 */
public class BlockingQueueOrderBoard implements OrderBoard {

  BlockingQueue<Order> orders;

  public BlockingQueueOrderBoard() {
    orders = new LinkedBlockingQueue<Order>(5);
  }

  public void postOrder(Order toBeProcessed) {
    try {
      orders.put(toBeProcessed);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public Order cookOrder() {
    Order returnValue = null;
    try {
      returnValue = orders.take();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    return returnValue;
  }
}
