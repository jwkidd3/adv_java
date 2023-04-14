package examples.staticimport;

/**
 * StaticImport is an example illustration of using a static
 * member without leveraging the static import facility.
 */
class StaticImport {

  public static void main(String [] args) {
    double circumference = 7.7;
    double diameter = circumference * Math.PI;
    double roundedDiameter = Math.round(diameter);
    System.out.println("The diameter of the circle is: " + diameter);
    System.out.println("The rounded diameter is: " + roundedDiameter);
  }

}
