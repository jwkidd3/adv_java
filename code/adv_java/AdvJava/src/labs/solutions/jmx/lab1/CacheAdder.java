package labs.solutions.jmx.lab1;

import static examples.jmx.SharedResources.*;

import java.util.List;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class CacheAdder extends Thread {

  private boolean keepGoing = true;

  public void run() {
    while(keepGoing) {
      try {
        Thread.sleep(1000);
        List cache = (List) getResource(CACHE_KEY);
        if(cache != null)
          cache.add(System.currentTimeMillis());
      } catch(Exception e) {}
    }
  }

  public void setKeepGoing(boolean b) {
    keepGoing = b;
  }
}
