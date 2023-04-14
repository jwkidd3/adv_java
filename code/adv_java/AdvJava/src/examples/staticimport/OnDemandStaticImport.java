package examples.staticimport;

import static java.lang.Math.PI;
import static java.lang.Math.round;

/**
 * OnDemandStaticImport is an example illustration of using the
 * ondemand-static-import declaration to simplify access to static members
 * within the java.lang.Math class.
 */
class OnDemandStaticImport {

	public static void main(String[] args) {
		double circumference = 7.7;
		double diameter = circumference * PI;
		double roundedDiameter = round(circumference);
		System.out.println("The diameter of the circle is: " + diameter);
		System.out.println("The rounded diameter is: " + roundedDiameter);
	}

}
