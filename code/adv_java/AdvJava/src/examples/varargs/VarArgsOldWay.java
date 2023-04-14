package examples.varargs;

/**
 * The following illustrates the steps
 * required to support a flexible argument
 * list within a method. Specifically,
 * the method would have to declare it
 * accepts a "variable" list as an array
 * and the caller of the method would have
 * to convert that "variable" list into a
 * bound list (an array) before invoking it. 
 */
public class VarArgsOldWay {

  public static void main(String[] args) {
    String name = "John Doe";
    String book1 = "Hooked On Java";
    String book2 = "The Java Language Specification";
    //convert arguments into array
    String [] titles = {book1, book2};
    //pass arguments as array
    listBooks(name, titles);
  }

  private static void listBooks(String name, String[] titles) {
    System.out.print(name + " likes: ");
    for(int i=0;i<titles.length;i++) {
      System.out.print("\"" + titles[i] +"\"");
      if(i+1 < titles.length)
        System.out.print(",");
    }
    System.out.flush();
  }
}
