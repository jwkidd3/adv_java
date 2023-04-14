package examples.rmi;

/**
 * This class represents an
 * implementation of the Runner
 * as an RMI Service
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class RunnerService implements Runner {

  //the unique service id
  private String serviceID;

  /**
   * Constructor to build a RunnerService.
   * The service id is specified upon creation.
   *
   * @param sID the service id
   */
  public RunnerService(String sID) {
    serviceID = sID;
  }

  /**
   * Implementation of the Runner's execute method.
   * The implementation does nothing fancy.
   * It simply calls run on the specified task and then
   * returns the task. It does not make any modifications
   * or duplication of the task.
   *
   * @param task
   * @return the executed task
   */
  public Runnable execute(Runnable task) {
    task.run();
    System.out.println(serviceID + ": ran task-" + task);
    return task;
  }

  /**
   * In order for RunnerService to be a valid
   * Remote object, it needs a defined equals method.
   *
   * @param o
   * @return
   */
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    RunnerService that = (RunnerService) o;

    if (!serviceID.equals(that.serviceID)) return false;

    return true;
  }

  /**
   * In order for RunnerService to be a valid
   * Remote object, it needs a defined hashCode method.
   */
  public int hashCode() {
    return serviceID.hashCode();
  }

  /**
   * In order for RunnerService to be a valid
   * Remote object, it needs a defined toString method.
   */
  public String toString() {
    return "RunnerService{" +
           "serviceID='" + serviceID + '\'' +
           '}';
  }
}
