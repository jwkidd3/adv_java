package examples.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationReader {

	public static void main(String[] args) {
		OverrideExample oe = new OverrideExample();

		Class clazz = oe.getClass();

		Method[] methods = clazz.getMethods();
		
		for(Method m:methods)
		{
			Annotation[] ans=m.getAnnotations();
			for(Annotation an:ans)
			{
				//Lots os logic processing......
				System.out.println(an.toString());
			}
			//Another access
			if(m.isAnnotationPresent(MyAnnotation.class))
			{
				Annotation an=m.getAnnotation(MyAnnotation.class);
			}
		}

	}

}
