package labs.solutions.concurrent.basic;

/**
 * Copyright DevelopIntelligence 2007. All rights reserved.
 * <p/>
 * User: developintelligence llc
 * Date: Mar 8, 2010
 * Time: 4:29:03 PM
 */
public class SimpleThreadExample {
  public static void main(String[] args) throws InterruptedException {
    SimpleThread t = new SimpleThread("one");
    SimpleThread t2 = new SimpleThread("two");
    SimpleThread t3 = new SimpleThread("three");

    t.start(); 
   
    t2.start();
    t3.start();
  }
}
