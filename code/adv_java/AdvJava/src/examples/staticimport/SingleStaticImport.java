package examples.staticimport;

import static java.lang.Math.PI;
import static java.lang.Math.round;

/**
 * SingleStaticImport is a sample illustration of using the
 * single-static-import declaration to simplify access to a static member
 * within the java.lang.Math class.
 */
class SingleStaticImport {

  public static void main(String [] args) {
    double circumference = 7.7;
    double diameter = circumference * PI;
    double roundedDiameter = round(circumference);
    System.out.println("The diameter of the circle is: " + diameter);
    System.out.println("The rounded diameter of the circle is: " + diameter);
  }

}
