package examples.rmi;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

/**
 * This class represents a basic RMI BasicJMXClient
 * application. It finds an RMI based service
 * using the rmiregistry. Once the service has
 * been located, the client invokes a method
 * on the service.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class RMIClient {

  public static void main(String[] args) {
    try {
      //find the RMI service
      Runner runner = (Runner) Naming.lookup("runner");

      //create a Runnable to pass to the service
      Runnable task = new TimeLapsedRunner();

      //invoke the remote method, passing the runnable
      task = runner.execute(task);

      //calculate the time to execute the remote method
      long elapsed = ((TimeLapsedRunner) task).getTimeElapsed();
      System.out.println("Task took " + elapsed + " miliseconds to run");
    } catch (NotBoundException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
}
