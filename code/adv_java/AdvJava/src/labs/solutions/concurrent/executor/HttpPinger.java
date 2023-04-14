package labs.solutions.concurrent.executor;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class HttpPinger implements Runnable {

	private URL theHostToTest;
	private AtomicInteger successCount= new AtomicInteger();

	public HttpPinger(URL url) {
		theHostToTest = url;
	}

	public AtomicInteger getSuccess() {
		return successCount;
	}
	
	public void resetSuccess()
	{
		successCount.set(0);
	}

	public void run() {
		try {
			HttpURLConnection connection = (HttpURLConnection) theHostToTest
					.openConnection();

			// just see if we can access it
			connection.setRequestMethod("HEAD");
			connection.connect();

			// the HTTP response code
			int responseCode = connection.getResponseCode();

			if (responseCode != HttpURLConnection.HTTP_OK) {
				System.out.println("Failed attempt");
			} else {
				
				successCount.incrementAndGet();
				System.out.println("Connected ok: " + theHostToTest + " ("
						+ successCount + ") : " + System.currentTimeMillis());
			}
			connection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
