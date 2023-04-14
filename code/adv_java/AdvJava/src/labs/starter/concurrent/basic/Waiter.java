package labs.starter.concurrent.basic;

/**
 * A waiter creates orders and
 * adds them to the SemaphoreOrderBoard.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class Waiter implements Runnable {

  private OrderBoard ordersToServe;

  public Waiter(OrderBoard orders) {
    ordersToServe = orders;
  }

  public void run() {
    while(true) {
      Order newOrder = new Order();
      if(newOrder.getOrderNumber() % 2 == 0) {
        newOrder.setMenuItem("Hamburger");
      } else {
        newOrder.setMenuItem("Cheeseburger");
      }

      ordersToServe.postOrder(newOrder);
      System.out.printf("Order IN [%d]: %s\n",
                        newOrder.getOrderNumber(), newOrder.getMenuItem());
    }
  }
}
