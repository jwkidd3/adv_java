package examples.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * The following represents an
 * RMI Application. The RMI application
 * creates a service and registers
 * it with a locally running RMI Registry.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class RMIServer {

  public static void main(String[] args) {
    //create an instance of the service
    Runner runner = new RunnerService("Service1");
    try {
      //convert the service into a remote object
      Remote runnerStub = UnicastRemoteObject.exportObject(runner, 0);

      //register the remote object's stub with rmiregisty
      Naming.rebind("runner", runnerStub);

    } catch (RemoteException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

}
