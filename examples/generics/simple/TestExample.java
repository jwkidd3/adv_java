package examples.generics.simple;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * The following example illustrates
 * the use of a type-safe collection
 */
public class TestExample {

  public static void main(String[] args) {
    //typesafe List of String elements
    List<String> myList = new ArrayList<String>();

    //convert args into a List<String>
    List<String> argList = Arrays.asList(args);
    myList.addAll(argList);

    //would cause compile-time error
    //myList.add(new Integer(0));

    //Iterator is now also typesafe
    Iterator<String> theArgs = myList.iterator();
    while(theArgs.hasNext()) {
      String nextArg = theArgs.next();
    }
  }
}
