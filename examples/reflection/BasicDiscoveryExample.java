package examples.reflection;

import java.lang.reflect.Modifier;

/**
 * BasicDiscoveryExample provides a
 * basic example of how you can "interrogate"
 * a dynamically loaded class for
 * information about its structure.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class BasicDiscoveryExample {

    public static void main(String[] args) {
      if (args.length == 0) {
        System.out.println("Please specify a classname");
        System.exit(0);
      }
      
      try {
        //get the class
        Class clazz = getClasss(args[0]);
        //some class information
        printBasicClassInfo(clazz);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("Could not load: " + args[0]);
      }
    }

    private static Class getClasss(String className)
                      throws ClassNotFoundException {
      Class returnValue = null;
      returnValue = Class.forName(className);
      return returnValue;
    }

  /**
   * printBasicClassInfo prints the following class information:
   * <ul>
   *  <li>Class name using getSimpleName
   *  <li>Class type using isInterface and isEnumeration
   *  <li>Class access modifiers using getModifiers
   *  <li>Class package name using getPackage
   *  <li>Class' parent name
   *
   * @param clazz
   */
    private static void printBasicClassInfo(Class clazz) {
      Package containPkg = clazz.getPackage();
      String className = clazz.getSimpleName();
      boolean isInterface = clazz.isInterface();
      boolean isEnum = clazz.isEnum();
      String typeStructure = (isInterface ? "interface" :
                              (isEnum ? "enumeration" : "class"));

      String modifiers = Modifier.toString(clazz.getModifiers());
      String pkgName = containPkg.getName();

      System.out.println("Class simple name: " + className);
      System.out.println(className + " is a " + typeStructure);
      System.out.println(className + " is considered " + modifiers);
      System.out.println(className + " belongs to " + pkgName);

      //parent class
      Class parent = clazz.getSuperclass();
      if(parent != null) {
        System.out.println(className + "'s parent : " + parent.getName());
        System.out.println("\nParent information");
        printBasicClassInfo(parent);
      }

    }

}
