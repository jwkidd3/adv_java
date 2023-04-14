package labs.solutions.jmx.lab2;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class Manager implements ManagerMBean {

  /**
   * The cache manager
   */
  private CacheManagerMBean cacheManager;
  private ObjectName mBeanName;

  public Manager() throws MalformedObjectNameException {
    mBeanName = new ObjectName("labs.jmx:type=CacheManager");
  }

  /**
   * Creates and installs a new CacheManager MBean
   * in the platform MBeanServer if it does not exist.
   * Otherwise does nothing.
   *
   * @return
   */
  public boolean installCacheManager() {
    boolean returnValue = false;
    MBeanServer server = ManagementFactory.getPlatformMBeanServer();

    if(cacheManager == null && !server.isRegistered(mBeanName)) {
      try {
        cacheManager = new CacheManager();
        server.registerMBean(cacheManager, mBeanName);
        returnValue = cacheManager.createNewCache();
      } catch(Exception e) {
        System.out.println("Could not create or register new CacheManager");
        e.printStackTrace();
      }
    }

    return returnValue;
  }

  /**
   * Removes the CacheManager MBean from
   * the MBean server, if it exists. Otherwise
   * does nothing.
   *
   * @return
   */
  public boolean removeCacheManager() {
    boolean returnValue = false;
    MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    if(cacheManager != null && server.isRegistered(mBeanName)) {
      try {
        server.unregisterMBean(mBeanName);
        cacheManager.deleteCache();
        cacheManager = null;
        returnValue = true;
      } catch (Exception e) {
        System.out.println("Could not remove CacheManager");
        e.printStackTrace();
      }
    }
    return returnValue;
  }
}
