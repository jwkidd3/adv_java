package examples.enums;

/**
 * DaysValueExample2 illustrates accessing
 * the values associated with the Days
 * enum type. The readable name of each value
 * is printed to standard out.
 */
public class DaysValuesExample2 {

  public static void main(String[] args) {
    for(Days d : Days.values())
      System.out.println(d.getReadableName());
  }

}
