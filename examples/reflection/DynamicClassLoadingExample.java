package examples.reflection;

/**
 * The following example illustrates the
 * dynamic class loading capabilities built
 * into the Java Virtual Machine.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class DynamicClassLoadingExample {

  public static void main(String[] args) {
    if(args.length == 0) {
      System.out.println("Please specify a classname");
      System.exit(0);
    }

    Class clazz = null;
    try {
      clazz = getClasss(args[0]);
      System.out.println("Class name: " + clazz.getName());
      System.out.println("Class simple name: " + clazz.getSimpleName());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.out.println("Could not load: " + args[0]);
    }
  }

  private static Class getClasss(String className) throws ClassNotFoundException {
    Class returnValue = null;
    returnValue = Class.forName(className);
    return returnValue;
  }
}
