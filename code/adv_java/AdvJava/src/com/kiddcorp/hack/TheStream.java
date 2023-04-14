package com.kiddcorp.hack;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class TheStream {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

		Integer res = integers.stream().filter(integer -> integer % 2 == 1).map(integer -> integer * integer).reduce(0,
				Integer::sum);
		System.out.println(res);

		OptionalInt sumOpt = integers.stream().mapToInt(Integer::intValue).reduce(Integer::sum);
		sumOpt.ifPresent(value -> System.out.println("------sum----> " + value));

		integers.stream().parallel().forEach(System.out::println);
		integers.stream().parallel()
				.forEach(integer -> System.out.println(Thread.currentThread().getName() + " - " + integer));
		System.out.println("----- ORDERED ----");
		integers.stream().parallel()
		.forEachOrdered(integer -> System.out.println(Thread.currentThread().getName() + " - " + integer));

	}

}
