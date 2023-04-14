package examples.generics.simple;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * OldWayExample illustrates using a raw type
 * Collection. Raw type collections are not
 * typesafe
 */
public class OldWayExample {

  public static void main(String[] args) {
    List myList = new ArrayList();
    //convert args into a List
    List argList = Arrays.asList(args);
    //add Strings to list
    myList.addAll(argList);
    //list is not typesafe, can add any object
    myList.add(new Integer(0));

    Iterator theArgs = myList.iterator();

    //step through list elements
    while (theArgs.hasNext()) {
      //will cause class cast
      // exception with Integer element
      String nextArg = (String) theArgs.next();
    }
  }
}
