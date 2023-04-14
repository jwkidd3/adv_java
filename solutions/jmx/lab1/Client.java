package labs.solutions.jmx.lab1;

import javax.management.remote.JMXServiceURL;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class Client {

  public static void main(String[] args) throws Throwable {
    System.out.println("JXM BasicJMXClient using RMI Connector");
    JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9001/jmxrmi");
    JMXConnector connector = JMXConnectorFactory.connect(url);
    MBeanServerConnection serverConnection = connector.getMBeanServerConnection();
    System.out.println("Got connection to : " + url);
    ObjectName mBeanName = new ObjectName("labs.jmx:type=CacheManager");
    /*
    ObjectInstance instance = serverConnection.getObjectInstance(mBeanName);
    Object mBeanProxy = MBeanServerInvocationHandler.newProxyInstance(serverConnection, mBeanName, examples.jmx.CacheManagerMBean.class, false);
    MBeanServerInvocationHandler invoker = new MBeanServerInvocationHandler(serverConnection, mBeanName);

    Method create = examples.jmx.CacheManagerMBean.class.getMethod("createNewCache", null);

    invoker.invoke(mBeanProxy, create, null);
    */

    //create a new cache
    String operationName = "createNewCache";
    Object [] operationParameters = null;
    String [] operationSignature = null;
    Object result = serverConnection.invoke(mBeanName,operationName, operationParameters, operationSignature);

    //get the size of the cache
    String attributeName = "CacheSize";

    Thread.sleep(1000);
    result = serverConnection.getAttribute(mBeanName, attributeName);
    System.out.println("Cache Size is: " + result);

    /*
    MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    ObjectName mBeanName = new ObjectName("examples.jmx:type=CacheManager");
    ObjectInstance mgr = server.getObjectInstance(mBeanName);
    */
    //System.out.println("mgr: " + mgr);
  }
}
