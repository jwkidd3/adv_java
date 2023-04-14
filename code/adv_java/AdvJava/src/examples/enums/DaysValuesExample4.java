package examples.enums;

/**
 * DaysValueExample3 illustrates accessing
 * the values associated with the Days
 * enum type. The toString of each value
 * is printed to standard out.
 */
public class DaysValuesExample4 {

  public static void main(String[] args) {
    for(DaysToo d : DaysToo.values())
      System.out.println(d);
  }

}
