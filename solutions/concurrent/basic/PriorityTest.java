package labs.solutions.concurrent.basic;

/**
 * This class illustrates the pre-emptive nature
 * of the Java platform.
 * 
 * @author developintelligence llc
 * @version 1.0
 */
public class PriorityTest {

  public static void main(String[] args) throws InterruptedException {
    Thread t = new Thread(new Runnable() {
      public void run() {
        while(true)
          System.out.println("T running");
      }
    });
    t.setPriority(Thread.MAX_PRIORITY);

    Thread t2 = new Thread(new Runnable() {
      public void run() {
        while(true)
          System.out.println("T2 running");
      }
    });

    t2.start();
    Thread.sleep(500);
    t.start();
  }
}
