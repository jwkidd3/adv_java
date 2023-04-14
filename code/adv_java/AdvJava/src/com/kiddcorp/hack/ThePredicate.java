package com.kiddcorp.hack;

import java.util.function.Predicate;

public class ThePredicate {

	public static void main(String[] args) {
		System.out.println(verificationEmail("test"));
		
		Predicate<String> predEmail=(email) -> email.contains("@");
		System.out.println(predEmail.test("bubba@yahoo.com"));

	}

	private static boolean verificationEmail(String email) {
		return (email.contains("@")) ? true : false;
	}
}
