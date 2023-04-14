package examples.autobox;

/**
 * The following example provides a simple
 * illustration of the autoboxing support
 * provided by Java SE 5.0.
 */
public class SimpleAutoboxingExample {

  public static void main(String[] args) {
    //box the int value of 32 into
    //a Integer reference
	
    Integer x = 32;
    
    //unbox the Integer reference into
    //a int value and multiply by 2
    int y = x * 2;

    //no boxing going on here
    System.out.println("The value of y is: " + y);
  }
}
