package examples.reflection.performance;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Copyright DevelopIntelligence 2007. All rights reserved.
 * <p/>
 * User: developintelligence llc
 * Date: Mar 11, 2010
 * Time: 10:48:57 AM
 */
public class ReflectionPerformanceTest {

  public static void main(String[] args) {

    int i = 0;
    long time = System.currentTimeMillis();

    for (; i < 1000000; i++)
      testNormal(args);

    long now = System.currentTimeMillis();
    System.out.println("Time per call: " + (((double) now - time) / (double) i));

    time = System.currentTimeMillis();

    for(i=0;i<100000;i++)
      testReflection(args);

    now = System.currentTimeMillis();
    System.out.println("Reflection Time per call: " + (((double) now - time) / (double) i));
//
//    testOptimizedReflection(args);

  }

  private static void testNormal(String[] args) {
      DataStructure ds = new DataStructure();
      List ls = ds.reversedList();
  }

  public static void testReflection(String[] args) {
    try {
      //get the class
      Class clazz = Class.forName("examples.reflection.performance.DataStructure");

      Object clazzInstance = clazz.newInstance();

      //reverse the list
      Method reverse = clazz.getMethod("reversedList");
      //invoke the method
      Object result = reverse.invoke(clazzInstance);

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Could not load: " + args[0]);
    }
  }

  public static void testOptimizedReflection(String [] args) {
    try {
      //get the class
      Class clazz = Class.forName("examples.reflection.performance.DataStructure");


      long then = System.currentTimeMillis();
      int i=0;
      for(;i<500000;i++) {
        Object clazzInstance = clazz.newInstance();

      //reverse the list
      Method reverse = clazz.getMethod("reversedList");
        //invoke the method
        Object result = reverse.invoke(clazzInstance);
      }

      long now = System.currentTimeMillis();
      System.out.println("Optimized: " + ((float) (now - then) / i));
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Could not load: " + args[0]);
    }
  }

}
