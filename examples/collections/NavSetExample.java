package examples.collections;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * This class illustrates the functionality of the NavigableSet collection
 * introduced as part of Java SE 6.
 *
 * Copyright DevelopIntelligence 2010. All rights reserved.
 *
 * User: developintelligence llc
 * Date: Mar 7, 2010
 * Time: 5:38:28 PM
 */
public class NavSetExample {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("NavSetExample needs one number");
            System.exit(0);
        }
        
        NavigableSet<Integer> set = new ConcurrentSkipListSet<Integer>();
        for(int i=0;i<100;i++)
            set.add(i);

        Integer num = Integer.parseInt(args[0]);
        int result = set.lower(num);
        System.out.printf("Lower for %d is %d\n", num, result);

        result = set.higher(num);
        System.out.printf("Higher for %d is %d", num, result);
    }
}
