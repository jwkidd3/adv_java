package examples.concurrent.advanced;


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

  private boolean moreToCook = true;
  private int burgersCooked = 0;

  private OrderBoard ordersToCook;

  public Cook(OrderBoard orders) {
    ordersToCook = orders;
  }

  public void run() {
    while(moreToCook) {
      Order tmpOrder = ordersToCook.cookOrder();
      try {
        //cooking time
        Thread.sleep(500);
        System.out.printf("Order up [%d]: %s\n",
                          tmpOrder.getOrderNumber(), tmpOrder.getMenuItem());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        
      }
    }
  }
}
