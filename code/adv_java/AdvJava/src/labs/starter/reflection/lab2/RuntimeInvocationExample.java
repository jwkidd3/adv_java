package labs.starter.reflection.lab2;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

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

    Class clazz = null;
    try {
      clazz = getClasss(args[0]);
      Object clazzInstance = clazz.newInstance();
      Method toString = clazz.getMethod("toString", null);
      Object result = toString.invoke(clazzInstance, null);
      String className = clazz.getSimpleName();
      System.out.println(className + ".toString result: " + result);
    } catch(ClassNotFoundException e){
      e.printStackTrace();
      System.out.println("Could not load: " + args[0]);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  private static Class getClasss(String className) throws ClassNotFoundException {
    Class returnValue = null;
    returnValue = Class.forName(className);
    return returnValue;
  }
}
