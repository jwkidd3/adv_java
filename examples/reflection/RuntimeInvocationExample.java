package examples.reflection;

import java.lang.reflect.Method;
/**
 * @author developintelligence llc
 * @version 1.0
 */
public class RuntimeInvocationExample {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify a classname");
      System.exit(0);
    }

    try {
      //get the class
      Class clazz = getClasss(args[0]);
      String className = clazz.getSimpleName();
      //create the instance
      Object clazzInstance = clazz.newInstance();
      //find the toString method
      Method toString = clazz.getMethod("toString", null);
      //invoke the method
      Object result = toString.invoke(clazzInstance, null);
      //print the results
      System.out.println(className + ".toString result: " + result);
    } catch(Exception e) {
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
}