package examples.concurrent.executor;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ScheduledFuture;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class HttpPinger implements Runnable {

  private boolean keepTesting = true;
  private URL theHostToTest;
  private ScheduledFuture scheduledFuture;

  public HttpPinger(URL url) {
    theHostToTest = url;
  }

  public void run() {
    try {
      HttpURLConnection connection =
              (HttpURLConnection) theHostToTest.openConnection();

      //just see if we can access it
      connection.setRequestMethod("HEAD");
      connection.connect();

      //the HTTP response code
      int responseCode = connection.getResponseCode();

      if (responseCode != HttpURLConnection.HTTP_OK) {
        System.out.println("Failed attempt");
      } else {
        System.out.println("Connected ok: "+System.currentTimeMillis());
      }
      connection.disconnect();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
