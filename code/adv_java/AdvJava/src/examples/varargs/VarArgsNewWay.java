package examples.varargs;

/**
 * The following illustrates the simplification
 * provided by the varargs mechanism when
 * working with variable argument lists. The
 * method no longer needs to declare an array,
 * nor does the caller need to convert the
 * elements into an array.
 */
public class VarArgsNewWay {

  public static void main(String[] args) {
    String name = "John Doe";
    String book1 = "Hooked On Java";
    String book2 = "The Java Language Specification";
    //pass arguments as arguments
    listBooks(name, book1, book2);
  }

  private static void listBooks(String name, String... titles) {
    System.out.print(name + " likes: ");
    for(int i=0;i<titles.length;i++) {
      System.out.print("\"" + titles[i] +"\"");
      if(i+1 < titles.length)
        System.out.print(",");
    }
    System.out.flush();
  }
}
