package labs.solutions.concurrent.executor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class CancelPinger implements Runnable {

	private ScheduledFuture future;
	private ScheduledExecutorService service;
	private HttpPinger pinger;

	public CancelPinger(HttpPinger p,ScheduledFuture f,
			ScheduledExecutorService pingService) {
		pinger=p;
		future = f;
		service = pingService;
	}

	public void run() {
		while(pinger.getSuccess().intValue() < 10)
		{}
		System.out.println("Cancelling Future");
		future.cancel(false);
		System.out.println("Resetting Success");
		pinger.resetSuccess();
		System.out.println("Rescheduling...");
		service.scheduleAtFixedRate(pinger, 1L,
                5L, TimeUnit.SECONDS);
		
		//service.shutdown();
	}
}
