package examples.foreach;

import java.util.Arrays;
import java.util.List;

/**
 * The following illustrates using the for-each
 * loop with a collection through the Iterable
 * interface.
 */
public class IterableForEachExample {

  public static void main(String[] args) {
    //convert the array into a list
    List argList = Arrays.asList(args);

    //iterate over the list
    for(Object arg : argList) {
      System.out.println(arg);
    }
  }
}
