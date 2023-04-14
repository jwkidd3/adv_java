package examples.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * The following example illustrates the dynamic class loading capabilities
 * built into the Java Virtual Machine.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class DynamicClassLoadingExample {

	public static void main(String[] args) {

		Class clazz = null;
		try {
			clazz = getClasss("com.kiddcorp.hack.ValueObject");
			System.out.println("Class name: " + clazz.getName());
			System.out.println("Class simple name: " + clazz.getSimpleName());
			System.out.println("Superclass: "+clazz.getSuperclass());
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				System.out.println(m.getName());
				Parameter[] p=m.getParameters();
			     for (Parameter x: p) {
			    	 System.out.println("    "+x.getName());
			     }
				Annotation[] annot = m.getAnnotations();
				for (Annotation annotation : annot) {
					System.out.println(annotation.getClass());
				}
			}
			Field[] f=clazz.getFields();
			for (Field field : f) {
				System.out.println(field.getName());
			}
			Object obj=clazz.newInstance();
			System.out.println(obj.getClass());

		} catch (Exception e) {
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
