package examples.concurrent.advanced;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Copyright DevelopIntelligence 2007. All rights reserved.
 * <p/>
 * User: developintelligence llc
 * Date: Mar 9, 2010
 * Time: 4:30:35 PM
 */
public class BusBoyBarrier extends Thread {

  private static Random randomGenerator = new Random();

  private CyclicBarrier barrier;

  BusBoyBarrier(CyclicBarrier barrier) {
    this.barrier = barrier;
  }

  public void run() {
    try {
      System.out.println("BusBoy cleaning table ");
      int sleepTime = Math.abs(randomGenerator.nextInt());
      Thread.sleep(1000);
      System.out.println("BusBoys waiting: " + barrier.getNumberWaiting());
      barrier.await();
      
      System.out.println("This is after the Barrier....");

    } catch(InterruptedException ie) {
      System.out.println(ie);
    } catch (BrokenBarrierException e) {
      System.out.println(e);
    }
  }
}