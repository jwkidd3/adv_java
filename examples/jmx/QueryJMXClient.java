package examples.jmx;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Set;
import java.util.Iterator;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class QueryJMXClient {

  public static void main(String[] args) throws Throwable {
    //create JMXServiceURL
    String jmxUrl = "service:jmx:rmi:///jndi/rmi://localhost:9001/jmxrmi";
    JMXServiceURL url = new JMXServiceURL(jmxUrl);

    //connect to MBeanServer
    JMXConnector connector = JMXConnectorFactory.connect(url);
    MBeanServerConnection serverConnection = connector.getMBeanServerConnection();
    System.out.println("Got connection to : " + url);

    //Describe remote MBean in terms of ObjectName
    ObjectName mBeanName = new ObjectName("examples.jmx:type=CacheManager");
    QueryExp query = Query.lt(Query.attr("CacheSize"), Query.value(0));
    //Query the MBean server for matches
    Set<ObjectInstance> mBeans = serverConnection.queryMBeans(mBeanName, query);

    //handle the matches
    Iterator<ObjectInstance> iterator = mBeans.iterator();
    while(iterator.hasNext()) {
      //initialize a cache for all CacheManagers with no cache
      ObjectInstance tmpMBean = iterator.next();
      String operationName = "createNewCache";
      Object[] opParams = null;
      String[] opSig = null;
      Object result = serverConnection.invoke(mBeanName, operationName, opParams, opSig);
      System.out.printf("%s %s result: %s\n", mBeanName, operationName, result);
    }

  }
}
