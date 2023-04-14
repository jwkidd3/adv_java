package com.kiddcorp.lambda;

public class PersonRunner {

	public static void main(String[] args) {
		IPerson p=new PersonImpl();
		
		System.out.println(p.do1());
		
		System.out.println(p.do2());
		
		System.out.println(((IHuman)p).doHuman());
	}

}
