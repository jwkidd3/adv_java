package labs.solutions.concurrent.executor;

import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * This application tests the availability of a web server. To do this, it opens
 * a URL connection at a specific timed interval.
 * 
 * In order to limit bandwidth usage, the request makes an HTTP HEAD request.
 * 
 * 
 * @author developintelligence llc
 * @version 1.0
 */
public class TimedPing {

	public static void main(String[] args) throws Exception {

		// URL url = new URL(args[0]);
		URL[] urls = new URL[10];
		urls[0] = new URL("http://cnn.com");
		urls[1] = new URL("http://google.com");

		HttpPinger[] pinger = new HttpPinger[10];
		pinger[0] = new HttpPinger(urls[0]);
		pinger[1] = new HttpPinger(urls[1]);

		// create a scheduled execution service
		ScheduledExecutorService pingService = Executors
				.newScheduledThreadPool(10);

		ScheduledFuture[] future = new ScheduledFuture[10];

		// schedule the HttpPinger to ping every 5
		future[0] = pingService.scheduleAtFixedRate(pinger[0], 1L, 1L,
				TimeUnit.SECONDS);
		future[1] = pingService.scheduleAtFixedRate(pinger[1], 1L, 1L,
				TimeUnit.SECONDS);

		// schedule a task to cancel the pinger after 5 minutes
		// task should also notify the service to shutdown
		pingService.schedule(
				new CancelPinger(pinger[0], future[0], pingService), 0,
				TimeUnit.SECONDS);
		pingService.schedule(
				new CancelPinger(pinger[1], future[1], pingService), 0,
				TimeUnit.SECONDS);
	}
}
