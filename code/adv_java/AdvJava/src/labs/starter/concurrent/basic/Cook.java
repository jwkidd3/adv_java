package labs.starter.concurrent.basic;

/**
 *
 * The following example represents
 * a Cook that processes orders by
 * taking them from the menu board
 * and cooking them.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class Cook implements Runnable {

  private OrderBoard ordersToCook;

  public Cook(OrderBoard orders) {
    ordersToCook = orders;
  }

  public void run() {
    while(true) {
      Order tmpOrder = ordersToCook.cookOrder();
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.printf("Order up [%d]: %s\n",
                          tmpOrder.getOrderNumber(), tmpOrder.getMenuItem());
      }
    }
  }
}
