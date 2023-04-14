package com.intuit.stuff;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class TheStream {
	public static void main(String args[]) {
		List<Integer> integers=Arrays.asList(1,2,3,4,5);
		Integer res=integers.stream().filter(integer->integer % 2==1).map(integer -> integer * integer).
				reduce(0,Integer::sum);
		System.out.println(res);
		
		OptionalDouble res2=integers.stream().mapToDouble(num -> (double)num).average();
		System.out.println(res2.getAsDouble());
//	integers.stream().parallel().forEach(System.out::println);
//	integers.stream().parallel().forEach(integer -> System.out.println(Thread.currentThread().getName()+
//			" - "+integer));
	
	integers.stream().parallel().forEachOrdered(integer -> System.out.println(Thread.currentThread().getName()+
			" - "+integer));
			
		
	}

}
