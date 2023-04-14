package com.kiddcorp.hack;

public interface IExample {
	void m1();
	
	default void m2() {
		System.out.println("Yes this is in an interface!!!");
	}
	

}
