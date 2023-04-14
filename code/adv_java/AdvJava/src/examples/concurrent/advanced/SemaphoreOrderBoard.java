package examples.concurrent.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.concurrent.Semaphore;

/**
 * SemaphoreOrderBoard represents a basic
 * order board in a restaraunt.
 *
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class SemaphoreOrderBoard implements OrderBoard {

  private List<Order> orders;
  private Semaphore fullSem, emptySem;


  /**
   * Create a new SemaphoreOrderBoard, initializing
   * the shared list.
   */
  public SemaphoreOrderBoard() {
    orders = Collections.synchronizedList(new ArrayList<Order>());
    fullSem = new Semaphore(5);
    emptySem = new Semaphore(0);
  }

  /**
   * add an order to the order board
   * @param toBeProcessed
   */
  public void postOrder(Order toBeProcessed) {
    try {
      fullSem.acquire(); //decrease permits by one
      orders.add(toBeProcessed);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      emptySem.release(); //increase permits by one
    }
  }

  /**
   * take an order for the order board to
   * cook.
   *
   * @return
   */
  public Order cookOrder() {
    Order tmpOrder = null;
    try {
      emptySem.acquire(); //decrease permits by one
      tmpOrder = orders.remove(0);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(orders.size() < 3)
        fullSem.release(); //increae permits by one
    }

    return tmpOrder;
  }
}
