package examples.jmx;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class BasicJMXClient {

  public static void main(String[] args) throws Exception {

    //create JMXServiceURL
    String jmxUrl = "service:jmx:rmi:///jndi/rmi://localhost:19001/jmxrmi";
    JMXServiceURL url = new JMXServiceURL(jmxUrl);

    //connect to MBeanServer
    JMXConnector connector = JMXConnectorFactory.connect(url);
    MBeanServerConnection serverConnection = connector.getMBeanServerConnection();
    System.out.println("Got connection to : " + url);

    //Describe remote MBean in terms of ObjectName
    ObjectName mBeanName = new ObjectName("examples.jmx:type=CacheManager");

    //Describe attribute
    String attributeName = "CacheSize";

    //get attribute from MBean
    Object result = serverConnection.getAttribute(mBeanName, attributeName);
    System.out.printf("%s result: %s\n", attributeName, result);

    //invoke operation on remote MBean
    String operationName = "createNewCache";
    Object[] opParams = null;
    String[] opSig = null;
    result = serverConnection.invoke(mBeanName, operationName, opParams, opSig);
    System.out.printf("%s result: %s\n", operationName, result);

    //get attribute from MBean
    result = serverConnection.getAttribute(mBeanName, attributeName);
    System.out.printf("%s result: %s\n", operationName, result);
  }
}
