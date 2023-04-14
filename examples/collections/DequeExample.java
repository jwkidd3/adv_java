package examples.collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

/**
 * This class illustrates how to use a Deque introduced in Java SE 6.
 * <p/>
 * Copyright DevelopIntelligence 2007. All rights reserved.
 * <p/>
 * User: developintelligence llc
 * Date: Mar 7, 2010
 * Time: 5:08:35 PM
 */
public class DequeExample {

  public static void main(String[] args) {

    Deque deque = new ArrayDeque<String>(Arrays.asList(args));
    deque.addLast("\nThis should be last");
    deque.addLast("Now this should be last");

    //access elements in ascending order
    System.out.println("Ascending order");
    Iterator itr = deque.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }

    //access elements in descending order
    System.out.println("\nDescending order");
    itr = deque.descendingIterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }
}
