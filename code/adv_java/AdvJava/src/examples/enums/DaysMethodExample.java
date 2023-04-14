package examples.enums;
/**
 * DaysMethodExample illustrates invoking
 * a method on an enum field.
 */
public class DaysMethodExample {

  public static void main(String[] args) {
    Days today = Days.SUNDAY;
    System.out.println("Today is: " + today.getReadableName());
  }
}
