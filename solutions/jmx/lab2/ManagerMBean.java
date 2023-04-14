package labs.solutions.jmx.lab2;

import javax.management.MBeanRegistrationException;
import javax.management.NotCompliantMBeanException;
import javax.management.InstanceAlreadyExistsException;

/**
 * ManagerMBean represents an MBean that manages other MBeans.
 * It provides two management methods:
 * one relating to the installation of the CacheManager
 * the other relating to the removal of the CacheManager
 *
 * @author developintelligence llc
 * @version 1.0
 */
public interface ManagerMBean {

  /**
   * Creates and installs a new CacheManager MBean
   * in the platform MBeanServer if it does not exist.
   * Otherwise does nothing.
   *
   * @return
   */
  public boolean installCacheManager() throws MBeanRegistrationException, NotCompliantMBeanException, InstanceAlreadyExistsException;

  /**
   * Removes the CacheManager MBean from
   * the MBean server, if it exists. Otherwise
   * does nothing.
   *
   * @return
   */
  public boolean removeCacheManager();
}
