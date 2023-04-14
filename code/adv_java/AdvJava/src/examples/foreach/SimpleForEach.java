package examples.foreach;

/**
 * The following source code illustrates
 * a simple example of the enhanced for syntax.
 * The enhanced for syntax is used to iterate
 * over the command line arguments supplied to the
 * program and print them off on the standard out.
 */
public class SimpleForEach {

  public static void main(String[] args) {
    //initialization clause - String s
    //expression clause - args
    for(String s : args) {
      System.out.println(s);
    }
  }
}
