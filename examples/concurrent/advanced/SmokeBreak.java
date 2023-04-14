package examples.concurrent.advanced;

import java.util.concurrent.CyclicBarrier;

/**
 * Copyright DevelopIntelligence 2007. All rights reserved.
 * <p/>
 * User: developintelligence llc Date: Mar 9, 2010 Time: 4:39:16 PM
 */
public class SmokeBreak {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
			public void run() {
				System.out.println("BusBoy Smoke Break");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		for (int i = 0; i < 5; i++) {
			new BusBoyBarrier(barrier).start();
		}

		
		//		CountDownLatch latch = new CountDownLatch(5);
//
//		LatchWaiter waiter = new LatchWaiter(latch);
//		waiter.start();
//
//		for (int i = 0; i < 5; i++) {
//			new BusBoy(latch).start();
//		}
	}
}