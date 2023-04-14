package examples.formatter;

/**
 * Basic Formatter example.
 * 
 * @author developintelligence llc
 * @version 1.0
 */
public class BasicFormatOutputExample {

  public static void main(String[] args) {
    System.out.printf("The %s is %d years old\n", "dog", 11);
    System.out.printf("The %s is %d years old\n", "child", 7);
    System.out.printf("Your bank account has $%,.2f for its balance", 345.8956);
  }
}
