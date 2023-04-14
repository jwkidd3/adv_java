package com.kiddcorp.hack;

public class Tester {

	public static void main(String[] args) {
		TheTester tt=new TheTester();
		
		tt.m1();
		tt.m2();
		tt.m3();

	}

}
class TheTester implements IExample,IExample2 {

	@Override
	public void m1() {
		System.out.println("M1 Executed.....");
		
	}
	
}