package examples.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class CancelPinger implements Runnable {

  private ScheduledFuture future;
  private ExecutorService service;

  public CancelPinger(ScheduledFuture f, ExecutorService pingService) {
    future = f;
    service = pingService;
  }

  public void run() {
    future.cancel(false);
    service.shutdown();
  }
}
