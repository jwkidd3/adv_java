package labs.solutions.staticimport;

import java.util.*;
import static java.util.Arrays.asList;
import static java.util.Arrays.sort;
import static java.util.Arrays.toString;
import static java.util.Collections.frequency;

/**
 * Mixer is a stand-alone Java application.
 *
 * Mixer accepts any number of command line arguments.
 * If Mixer receives 3 or less arguments, Mixer sorts the arguments
 * using Arrays.sort and prints the resultant sorted array.
 *
 * If Mixer receives more than 3 arguments, Mixer sorts the arguments,
 * counts the frequency of each argument, and prints the arguments
 * and their frequency in sorted order.
 *
 * @author developintelligence llc
 * @version 1.0
 */
public class Mixer {

  public static void main(String[] args) {
    //write Mixer logic here
    switch(args.length) {
      case 0:
        break;
      case 1:
      case 2:
      case 3:
        sort(args);
        System.out.println(Arrays.toString(args));
      break;
      default:
        sort(args);
        Map frequencyMap = getFrequencyMap(args);
        printFrequencyMap(frequencyMap);
      break;
    }
  }

  private static Map getFrequencyMap(String[] args) {
    Map returnMap = new TreeMap();
    List list = asList(args);

    for(int i=0;i<args.length;i++) {
      if(!returnMap.containsKey(args[i])) {
        int freq = frequency(list, args[i]);
        returnMap.put(args[i], new Integer(freq));
      }
    }

    return returnMap;
  }

  private static void printFrequencyMap(Map frequencyMap) {
    Iterator keys = frequencyMap.keySet().iterator();
    while(keys.hasNext()) {
      String key = (String) keys.next();
      Integer value = (Integer) frequencyMap.get(key);
      System.out.println(key + "=" + value);
    }
  }

}
