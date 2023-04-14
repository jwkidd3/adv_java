package examples.concurrent.executor;

import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * This application tests the availability
 * of a web server. To do this, it opens a
 * URL connection at a specific timed interval.
 *
 * In order to limit bandwidth usage, the
 * request makes an HTTP HEAD request.
 *
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class TimedPing {

  public static void main(String[] args) throws Exception {

    URL url = new URL("http://cnn.com");
    HttpPinger pinger = new HttpPinger(url);

    //create a scheduled execution service
    //only need one thread to perform ping functionality
    ScheduledExecutorService pingService =
            Executors.newSingleThreadScheduledExecutor();

    //schedule the HttpPinger to ping every ping
    ScheduledFuture future =
            pingService.scheduleAtFixedRate(pinger, 30L,
                                            60L, TimeUnit.SECONDS);

    //schedule a task to cancel the pinger after 5 minutes
    //task should also notify the service to shutdown
    pingService.schedule(new CancelPinger(future, pingService),
                                          60*5, TimeUnit.SECONDS);
    
    System.out.println("This is the end of the method");
  }
}
