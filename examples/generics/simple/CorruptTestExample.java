package examples.generics.simple;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * The following example illustrates
 * the use of a type-safe collection
 */
public class CorruptTestExample {

  public static void main(String[] args) {
    //typesafe List of String elements
    List<String> myList = new ArrayList<String>();

    //convert args into a List<String>
    List<String> argList = Arrays.asList(args);
    myList.addAll(argList);

    //call third-party api which uses raw types
    ThirdPartyAPI.addElement(myList);

    //Iterator is now also typesafe
    Iterator<String> theArgs = myList.iterator();
    while(theArgs.hasNext()) {
      String nextArg = theArgs.next();
    }
  }
}
