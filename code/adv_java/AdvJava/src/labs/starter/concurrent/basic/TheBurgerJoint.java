package labs.starter.concurrent.basic;

/**
 * The application that starts the waiter
 * and the cook.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class TheBurgerJoint {

  public static void main(String[] args) {
    OrderBoard orders = new OrderBoard();

    Runnable cook = new Cook(orders);
    Runnable waiter1 = new Waiter(orders);
    Thread producer = new Thread(waiter1);
    Thread consumer = new Thread(cook);
    producer.start();
    consumer.start();
  }
}
