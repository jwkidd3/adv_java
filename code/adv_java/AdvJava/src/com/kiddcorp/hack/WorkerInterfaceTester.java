package com.kiddcorp.hack;

public class WorkerInterfaceTester {
	public static void execute(WorkerInterface worker) {
		worker.doSomeWork("John");
	}
	public static void main(String[] args) {
		execute(new WorkerInterface() {
			public void doSomeWork(String x) {
				System.out.println("Worker using anonymous class...->" + x);
			}
		});
		WorkerInterface wi= (x) -> System.out.println(x);
		wi.doSomeWork("Bubba");
		execute(wi);
		StringToInt stringToInt=(String str) -> str.length();
		Integer length=stringToInt.map("Hello Lambda!");
		System.out.println("Length: "+length);
	}
	@FunctionalInterface
	public interface StringToInt{
		Integer map(String str);
	}
}

