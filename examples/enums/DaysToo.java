package examples.enums;

/**
 * Days is a basic illustration of an
 * enumerated type within the Java language.
 */
enum DaysToo {
  SUNDAY ("Sunday"), MONDAY ("Monday"),
  TUESDAY ("Tuesday"), WEDNESDAY ("Wednesday"),
  THURSDAY ("Thursday"), FRIDAY ("Friday"),
  SATURDAY;

  private String readableName;

  DaysToo() {
    readableName = name();
  }

  DaysToo(String s) {
    readableName = s;
  }
  
  public String getReadableName() {
    return readableName;
  }

  public String toString() {
    return getReadableName();
  }
}
