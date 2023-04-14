package examples.enums;

/**
 * DaysValueExample illustrates accessing
 * the values associated with the Days
 * enum type. The name of each value
 * is printed to standard out.
 */
public class DaysValuesExample {

  public static void main(String[] args) {
    for(Days d : Days.values())
      System.out.println(d.name());
  }

}
