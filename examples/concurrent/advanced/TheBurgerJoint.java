package examples.concurrent.advanced;

/**
 * The application that starts the waiter
 * and the cook.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class TheBurgerJoint {

  public static void main(String[] args) throws InterruptedException {
    //OrderBoard orders = new BlockingQueueOrderBoard();
    OrderBoard orders = new LockOrderBoard();
    //OrderBoard orders = new SemaphoreOrderBoard();

    Runnable cook = new Cook(orders);
    Runnable waiter1 = new Waiter(orders);
    Thread producer = new Thread(waiter1);
    Thread consumer = new Thread(cook);
    consumer.start();
    producer.start();
  }
}
