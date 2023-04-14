package labs.solutions.concurrent.basic;

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
    while (moreToCook) {
      Order tmpOrder = ordersToCook.cookOrder();
      try {
        //cooking time
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        burgersCooked++;
        System.out.printf("Order up [%d]: %s\n",
                          tmpOrder.getOrderNumber(), tmpOrder.getMenuItem());

        if (burgersCooked == 290) {
          //bring in the scab
          new Thread(new Cook(ordersToCook)).start();
        }

        //shifts done
        if (burgersCooked == 300) {
          moreToCook = false;
        }
      }
    }
  }
}
