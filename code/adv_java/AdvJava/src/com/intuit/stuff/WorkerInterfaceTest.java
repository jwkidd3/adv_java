package com.intuit.stuff;

import java.util.function.Predicate;

public class WorkerInterfaceTest {
	public static void execute(WorkerInterface worker) {
		worker.doSomething("John");
	}

	public static void main(String[] args) {
		execute(new WorkerInterface() {
			public void doSomething(String x) {
				System.out.println("The value is: "+x);
			}
		});
		
		WorkerInterface wi=(x) -> System.out.println("Lambda: "+x);
		wi.doSomething("bubba");
		
		Runnable r=() -> {
			System.out.println("This is a runnable");
		};
		r.run();
		//Imperative
		System.out.println(verificationEmail("test"));
		//Declarative
		Predicate<String> predEx=(email) -> email.contains("@");
		
		System.out.println(predEx.test("bubba"));
		
		Predicate<String> predEx2=email -> email.contains(".com");
		System.out.println(predEx.and(predEx2).test("jkidd@kiddcorp.com"));
		
	}
	
	static boolean verificationEmail(String email) {
		return (email.contains("@")) ? true: false ;
	}

}
