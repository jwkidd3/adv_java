package examples.jmx;

import static examples.jmx.SharedResources.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author developintelligence llc
 * @version 1.0
 */
public class CacheManager implements CacheManagerMBean {

  private int initialSize = 20;

  public CacheManager() {}

  /**
   * Create a new default or initial sized cache
   * and register it for shared use.
   *
   * @return
   */
  public boolean createNewCache() {
    if(getResource(CACHE_KEY) != null)
      return false;

    List objectCache = new ArrayList(initialSize);
    return registerResource(CACHE_KEY, objectCache);
  }

  /**
   * Clear the cache's contents.
   */
  public void clearCache() {
    List cache = (List) getResource(CACHE_KEY);
    if(cache != null)
      cache.clear();
  }

  /**
   * Remote the cache from shared use.
   * Delete its contents and delete the cache.
   */
  public void deleteCache() {
    clearCache();
    removeRegistration(CACHE_KEY);
  }

  /**
   * returns the current size of the cache
   *
   * @return
   */
  public int getCacheSize() {
    List cache = (List) getResource(CACHE_KEY);
    if(cache != null)
      return cache.size();

    return -1;
  }

  /**
   * sets the initial size of the cache
   *
   * @param size
   */
  public void setCacheInitialSize(int size) {
    initialSize = size;
  }

  /**
   * returns the initial size of the cache
   *
   * @return
   */
  public int getCacheInitialSize() {
    return initialSize;
  }
}
