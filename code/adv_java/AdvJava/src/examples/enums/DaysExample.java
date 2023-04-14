package examples.enums;

/**
 * DaysExample illustrates simple access
 * to an enum field. 
 */
public class DaysExample {

  public static void main(String[] args) {
    Days today = Days.SUNDAY;
    System.out.println("Today is: " + today);
    System.out.println(Days.SUNDAY.getReadableName());
  }
}
