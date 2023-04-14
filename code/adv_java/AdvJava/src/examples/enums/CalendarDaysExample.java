package examples.enums;

/**
 * CalendarDaysExample illustrates using an
 * "inner" enum defined in the Calendar class.
 * It also illustrates accessing the ordinal
 * value associated with the enum value.
 */
public class CalendarDaysExample {

  public static void main(String[] args) {
    Calendar.Days today = Calendar.Days.SUNDAY;
    System.out.println("Today's ordinal is: " + today);
  }
}
