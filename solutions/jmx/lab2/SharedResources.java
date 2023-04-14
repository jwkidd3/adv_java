package labs.solutions.jmx.lab2;

import java.util.Map;
import java.util.HashMap;

/**
 * @author developintelligence llc
 * @version 1.0
 */
final public class SharedResources {

  public final static String CACHE_KEY = "shared_cache";
  private static final Map resources = new HashMap();

  /**
   * register resource registers the resource to
   * a non-existent key. if the key exists,
   * the resource will not be registered and the
   * method will return false.
   *
   * @param key
   * @param resource
   * @return
   */
  public static boolean registerResource(String key, Object resource) {
    if(resources.containsKey(key))
      return false;

    resources.put(key, resource);
    return true;
  }

  /**
   * removes the object from the shared resources
   * if it exists.
   *
   * @param key
   */
  public static void removeRegistration(String key) {
    if(resources.containsKey(key))
      resources.remove(key);
  }

  /**
   * returns the named resource or null if it does
   * not exist.
   *
   * @param key
   * @return
   */
  public static Object getResource(String key) {
    return resources.get(key);
  }
}
