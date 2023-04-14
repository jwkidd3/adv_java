package examples.rmi;

import java.io.Serializable;

/**
 * The following represents an
 * implementation of a Runnable
 * that can be executed by a Runner
 * service.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class TimeLapsedRunner implements Runnable, Serializable {

  //time holders
  private long creationTime, runTime, elapsedTime = -1;
  //flag representing run has executed
  private boolean hasRun;

  /**
   * Constructor initializes the creation time
   * associated with the TimeLapsedRunner instance.
   */
  public TimeLapsedRunner() {
    creationTime = System.currentTimeMillis();
  }

  /**
   * The task execution method. run
   * retrieves the current time in millis
   * from the remote system.
   */
  public void run() {
    runTime = System.currentTimeMillis();
    hasRun = true;
  }

  /**
   * calculates the elapsed time from object creation to
   * run execution.
   *
   * @return
   */
  public long getTimeElapsed() {
    if(hasRun) {
      elapsedTime = runTime - creationTime;
    }
    return elapsedTime;
  }
}
