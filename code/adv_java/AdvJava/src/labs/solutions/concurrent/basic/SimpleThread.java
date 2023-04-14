package labs.solutions.concurrent.basic;

/**
 * A SimpleThread.
 *
 * Copyright DevelopIntelligence 2007. All rights reserved.
 * <p/>
 * User: developintelligence llc Date: Mar 8, 2010 Time: 4:29:52 PM
 */
public class SimpleThread extends Thread {

	private long startTime;
	private long runTime;

	public SimpleThread() {
		super();
	}

	public SimpleThread(String s) {
		super(s);
	}

	@Override
	public void run() {

		runTime = System.nanoTime();

		System.out.printf("SimpleThread[%s:%d:%d][%s].run(): run was called\n", getName(), getId(), getPriority(),
				getThreadGroup().getName());
		System.out.printf("Elapsed time: %d nanoseconds\n", (runTime - startTime));
		startTime = System.nanoTime();

	}

	@Override
	public void start() {
		System.out.println("SimpleThread.start(): start was called");
		startTime = System.nanoTime();
		super.start();
	}

}
