package examples.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface defines a remote
 * interface which can be used
 * to create an RMI service implementation
 *
 * @author developintelligence llc
 * @version 1.0
 */
public interface Runner extends Remote {

  /**
   * execute represents a method
   * that can be invoked remotely to
   * execute a specified task.
   *
   * @param task
   * @return the completed task
   * @throws RemoteException
   */
  public Runnable execute(Runnable task) throws RemoteException;

}
