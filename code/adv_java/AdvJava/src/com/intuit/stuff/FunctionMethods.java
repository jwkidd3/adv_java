package com.intuit.stuff;

import java.util.Date;
import java.util.function.Function;

public class FunctionMethods {

	public static void main(String[] args) {
		Function<String, String> indentityFunction = Function.identity();
		System.out.println(indentityFunction.apply("My Method"));

		Function<String, Integer> stringIntegerFunction = String::length;
		Function<Integer, Long> integerLongFunction = value -> value + 1L;
		Function<String,Long> stringLongFunction=stringIntegerFunction.andThen(integerLongFunction);
		System.out.println(stringLongFunction.apply("Hello And-Then"));
		
		Function<Date,String> dateStringFunction=Date::toString;
		Function<String,Integer> stringIntegerFunction2=String::length;
		Function<Date, Integer> compose=stringIntegerFunction2.compose(dateStringFunction);
		System.out.println(compose.apply(new Date()));
	}
}
