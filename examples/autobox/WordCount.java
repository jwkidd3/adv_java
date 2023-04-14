package examples.autobox;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 * WordCount illustrates the use of the
 * autoboxing functionality with the Collections
 * API.
 */
public class WordCount {

  public static void main(String[] args) {
    Map wordMap = new HashMap();
    for(int x=0;x<args.length;x++) {
      int wordCount = 1;
      if(wordMap.containsKey(args[x])) {
        wordCount = ((Integer) wordMap.get(args[x])) + 1;
      }
      wordMap.put(args[x], wordCount);
    }

    Iterator itr = wordMap.keySet().iterator();
    while(itr.hasNext()) {
      String key = (String) itr.next();
      int value = (Integer) wordMap.get(key);
      System.out.println(key + " has " + value + " occurrences");
    }

  }
}
