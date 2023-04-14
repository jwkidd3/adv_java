package labs.solutions.generics.lab1;

import java.util.*;

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
 * This version of the Mixer uses Autoboxing.
 * This version of the Mixer uses foreach syntax.
 * This version of the Mixer uses type-safe collections.
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
        Arrays.sort(args);
        System.out.println(Arrays.toString(args));
      break;
      default:
        Arrays.sort(args);
        Map<String, Integer> frequencyMap = getFrequencyMap(args);
        printFrequenceMap(frequencyMap);
      break;
    }
  }

  private static Map<String, Integer> getFrequencyMap(String[] args) {
    Map<String,Integer> returnMap = new TreeMap<String, Integer>();
    List<String> list = Arrays.asList(args);

    //converted to for-each syntax
    for(String arg : list) {
      if(!returnMap.containsKey(arg)) {
        int freq = Collections.frequency(list, arg);
        //converted to use auto-boxing
        returnMap.put(arg, freq);
      }
    }

    return returnMap;
  }

  private static void printFrequenceMap(Map<String, Integer> frequencyMap) {
    Iterator<String> keys = frequencyMap.keySet().iterator();
    while(keys.hasNext()) {
      String key = keys.next();
      //converted to use auto-unboxing
      int value = frequencyMap.get(key);
      System.out.println(key + "=" + value);
    }
  }

}
