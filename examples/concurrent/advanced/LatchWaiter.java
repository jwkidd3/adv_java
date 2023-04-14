package examples.concurrent.advanced;

import java.util.concurrent.CountDownLatch;

/**
 * Copyright DevelopIntelligence 2007. All rights reserved.
 * <p/>
 * User: developintelligence llc
 * Date: Mar 9, 2010
 * Time: 4:35:41 PM
 */
public class LatchWaiter extends Thread {

  private CountDownLatch latch;

  public LatchWaiter(CountDownLatch latch) {
    this.latch = latch;
  }

  public void run() {
    try {
      latch.await();
    } catch (InterruptedException e) { }
    System.out.println("All threads completed, waiter is going to work");
  }
}
