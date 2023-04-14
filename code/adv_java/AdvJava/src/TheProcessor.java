import java.lang.reflect.Method;

public class TheProcessor {

	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("MyClass");
			Object obj = clazz.newInstance();
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(CoolAnnotation.class)) {
					System.out.println(method.getName());
					method.invoke(obj, null);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
          Parent p=new Implementor();
          p.bubba();
	}

}
