package labs.solutions.reflection.lab2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class RuntimeInvocationExample {

  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Please specify a classname and a value");
      System.exit(0);
    }

    Class clazz = null;
    try {
      clazz = getClasss(args[0]);

      //find and invoke the construction which takes a string
      String[] params = new String [] { args[1] };
      Constructor constructor = clazz.getConstructor(new Class[] { String.class });
      Object clazzInstance = constructor.newInstance(params);

      //now that the object has been initialized with a value
      //we should see the passed in value as the result of
      //toString when it is invoked.
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
