package labs.solutions.enums.lab2;

import static labs.solutions.enums.lab2.Season.*;

/**
 *
 * Month is a basic illustration of an
 * enumerated type within the Java language.
 */
enum Month {
  JANUARY(WINTER),
  FEBRUARY(WINTER),
  MARCH(WINTER),
  APRIL(SPRING),
  MAY(SPRING),
  JUNE(SPRING),
  JULY(SUMMER),
  AUGUST(SUMMER),
  SEPTEMBER(FALL),
  OCTOBER(FALL),
  NOVEMBER(FALL),
  DECEMBER(WINTER);

  private Season season;

  private Month(Season season) {
    this.season = season;
  }

  public Season getSeason() {
    return season;
  }

  public static Month valueFactory(String monthString) {
    Month returnValue = null;
    try {
      returnValue = valueOf(monthString);
    } catch (IllegalArgumentException iae) {
      returnValue = valueOf(monthString.toUpperCase());
    }

    return returnValue;
  }
}
