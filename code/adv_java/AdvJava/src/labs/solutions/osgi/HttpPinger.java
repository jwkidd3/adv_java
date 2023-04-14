package labs.solutions.osgi;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author developintelligence llc
 * @version 1.0
 */
class HttpPinger implements Runnable {

  private volatile boolean keepTesting = true;
  private URL theHostToTest;
  private List<String> auditLog;


  public HttpPinger(String urlS) throws MalformedURLException {
    theHostToTest = new URL(urlS);
    auditLog = new ArrayList<String>();
  }

  public void run() {
    while(keepTesting) {
      try {
        HttpURLConnection connection =
                (HttpURLConnection) theHostToTest.openConnection();

        //just see if we can access it
        connection.setRequestMethod("HEAD");
        connection.connect();

        //the HTTP response code
        int responseCode = connection.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
          auditLog.add("Failed attempt " + System.currentTimeMillis());
        } else {
          auditLog.add("Connected ok: "+System.currentTimeMillis());
        }
        connection.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public List<String> getAuditLog() {
    return auditLog;
  }

  public String getUrl() {
    return theHostToTest.toString();
  }
}
