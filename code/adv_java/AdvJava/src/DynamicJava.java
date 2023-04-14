
public class DynamicJava {

	public static void main(String[] args) {
		try {
			Class<?> clazz=Class.forName("java.lang.String");
			System.out.println(clazz);
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
