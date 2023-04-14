package labs.solutions.metadata;

import static labs.solutions.metadata.Season.*;

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
      returnValue = Month.valueOf(monthString);
    } catch (IllegalArgumentException iae) {
      returnValue = Month.valueOf(monthString.toUpperCase());
    }

    return returnValue;
  }

  @Override
  public String toString() {
    StringBuffer tmpName = new StringBuffer(name().toLowerCase());
    String sub = name().substring(0,0);
    return tmpName.replace(0,0,sub).toString();
  }
}
