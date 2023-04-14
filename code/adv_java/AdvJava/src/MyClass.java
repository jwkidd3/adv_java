
public class MyClass {

	public void m1() {
		System.out.println("M1");
	}

	public void m2() {
		System.out.println("M2");
	}

	@CoolAnnotation
	public void m3() {
		System.out.println("Invoked->M3");
	}

	@CoolAnnotation
	public void m4() {
		System.out.println("Invoked->M4");
	}

}
