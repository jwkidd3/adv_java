package labs.starter.metadata;

import java.util.Arrays;

/**
 * MonthConvertor represents two basic features of
 * an enumeration - valueOf and switch support.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class MonthConvertor {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Sorry, please specificy a month");
      System.exit(0);
    }

    try {
      Month monthOfYear = Month.valueFactory(args[0]);
      System.out.println(monthOfYear + " is in " + monthOfYear.getSeason());
    } catch (IllegalArgumentException iae) {
      System.out.println("Sorry, " + args[0] + " is an invalid Month");
      System.out.println("Valid months are: " + Arrays.toString(Month.values()));
      System.exit(0);
    }
  }

  private static String getSeason(Month monthOfYear) {
    String returnValue = "Winter";
    switch (monthOfYear) {
      case APRIL:
      case MAY:
      case JUNE:
        returnValue = "Spring";
        break;
      case JULY:
      case AUGUST:
      case SEPTEMBER:
        returnValue = "Summer";
        break;
      case OCTOBER:
      case NOVEMBER:
        returnValue = "Fall";
        break;
    }
    return returnValue;
  }
}
