package labs.solutions.jmx.lab1;

/**
 * This interface represents the management
 * interface to a manageable resource. The
 * manageable resource represents a cache.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public interface CacheManagerMBean {

  /**
   * Create a new default or initial sized cache
   * and register it for shared use.
   * @return
   */
  public boolean createNewCache();

  /**
   * Clear the cache's contents.
   */
  public void clearCache();

  /**
   * Remote the cache from shared use.
   * Delete its contents and delete the cache.
   */
  public void deleteCache();

  /**
   * returns the current size of the cache
   * @return
   */
  public int getCacheSize();

  /**
   * sets the initial size of the cache
   * @param size
   */
  public void setCacheInitialSize(int size);

  /**
   * returns the initial size of the cache
   * @return
   */
  public int getCacheInitialSize();
  
}
