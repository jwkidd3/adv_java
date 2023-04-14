package examples.enums;
/**
 * DaysSwitchExample illustrates how
 * the enums can be used with the
 * switch statement.
 */
public class DaysSwitchExample {

  public static void main(String[] args) {
    Days today = Days.SATURDAY;
    String message = getMessage(today);
    System.out.print("Today is " + today);
    System.out.println(", I should go " + message);
  }

  private static String getMessage(Days today) {
    String message;
    switch(today) {
      case SATURDAY:
        message = "play";
        break;
      case SUNDAY:
        message = "to church";
        break;
      default:
        message = "work";
        break;
    }
    return message;
  }
}
