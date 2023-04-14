package com.kiddcorp.lambda;

public class WorkerInterfaceTest {
	public static void execute(WorkerInterface worker) {
		worker.doSomeWork("John");
	}

	public static void main(String[] args) {

		// invoke doSomeWork using Annonymous class
		execute(new WorkerInterface() {
			@Override
			public void doSomeWork(String x) {
				System.out
						.println("Worker invoked using Anonymous class: " + x);
			}
		});
		WorkerInterface wi = (x) -> System.out
				.println("Worker invoked using Lambda expression: " + x);
		wi.doSomeWork("Bubba");
		execute(wi);
	}
}
