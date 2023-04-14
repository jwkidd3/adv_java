package labs.solutions.jmx.lab2;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class CacheManagerAgent {

  public static void main(String[] args) throws Exception {
    MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    ObjectName mBeanName = new ObjectName("labs.jmx:type=Manager");
    ManagerMBean mBean = new Manager();
    server.registerMBean(mBean, mBeanName);
    Thread.currentThread().join();
  }
}
