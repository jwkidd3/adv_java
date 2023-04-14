package com.cisco;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;

public class _Stream {
    public static void main(String[] args) {
  
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        //1+9+25
        Integer res = integers.stream()
                .filter(integer -> integer % 2 == 1)
                .map(integer -> integer * integer)
                .reduce(0, Integer::sum);

        OptionalInt sumOptional = integers.stream().mapToInt(Integer::intValue).reduce(Integer::sum);
        sumOptional.ifPresent(value -> System.out.println("--------sum----------"+value));

        System.out.println("res : "+res);

        //foreachRemaining
        Iterator<Integer> iterator = integers.stream().iterator();
        iterator.forEachRemaining(System.out::println);

        System.out.println("--------parallel stream----------");
        //pareallel => thread diffrent
        integers.stream().parallel().forEach(System.out::println); // 3,5,4,1,2
        integers.stream().parallel()
                .forEach(integer -> System.out.println(Thread.currentThread().getName()+" /"+integer));
        //ordered
        System.out.println("-------foreach Ordered--------");
        integers.stream().parallel()
                .forEachOrdered(integer -> System.out.println(Thread.currentThread().getName()+" /"+integer));

        // => limit, skip,distinct remove parallel attribute
        //unordered is for parallel and order is not important
        integers.stream()
                .unordered()
                .parallel()
                .limit(2)
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);


    }
}