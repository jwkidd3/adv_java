package labs.solutions.varargs;

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
 * This version of the Mixer uses Autoboxing (see getFrequencyMap).
 * This version of the Mixer uses foreach syntax (see getFrequencyMap).
 * This version of the Mixer uses varargs (see print).
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
        print(args);
      break;
      default:
        Arrays.sort(args);
        Map frequencyMap = getFrequencyMap(args);
        printFrequenceMap(frequencyMap);
      break;
    }
  }

  private static void print(Object... tmpObj) {
    Object [] varArgs = (Object []) tmpObj;
    switch(varArgs.length) {
      case 2:
        System.out.println(varArgs[0] + "=" + varArgs[1]);
        break;
      default:
        System.out.println(Arrays.toString(varArgs));
        break;
    }
  }

  private static Map getFrequencyMap(String[] args) {
    Map returnMap = new TreeMap();
    List list = Arrays.asList(args);

    //converted to for-each syntax
    for(Object arg : list) {
      if(!returnMap.containsKey(arg)) {
        int freq = Collections.frequency(list, arg);
        //converted to use auto-boxing
        returnMap.put(arg, freq);
      }
    }

    return returnMap;
  }

  private static void printFrequenceMap(Map frequencyMap) {
    Iterator keys = frequencyMap.keySet().iterator();
    while(keys.hasNext()) {
      String key = (String) keys.next();
      Object value = frequencyMap.get(key);
      //converted to use print method
      print(key, value);
    }
  }

}
