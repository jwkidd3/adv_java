package examples.generics.advanced;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The following example illustrates
 * the use of a type-safe collection
 */
public class TestBoundedExample {

  public static void main(String[] args) {
    //typesafe List of Number elements
    List<Number> myList = new ArrayList<Number>();

    //call third-party api which uses raw types
    BoundedTypeSafeThirdPartyAPI.addElement(myList);

    //Iterator is now also typesafe
    Iterator<Number> theArgs = myList.iterator();
    while(theArgs.hasNext()) {
      Number nextArg = theArgs.next();
      System.out.println(nextArg);
    }
  }
}
