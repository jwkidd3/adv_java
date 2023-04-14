package com.kiddcorp.hack;

import java.util.Date;
import java.util.function.Function;

public class FunctionMethods {

	public static void main(String[] args) {
		Function<String,String> idFunction=Function.identity();
		System.out.println(idFunction.apply("Function Identity"));
		
		Function<String,Integer> strIntFunction=String::length;
		Function<Integer,Long> intLongFunction=value -> value+ 1L;
		Function<String,Long> strLongFunc=strIntFunction.andThen(intLongFunction);
		System.out.println(strLongFunc.apply("Hi and Then"));
		
		Function<Date,String> dateStrFunction=Date::toString;
		Function<String,Integer> strIntFunction2=String::length;
		Function<Date,Integer> compose=strIntFunction2.compose(Date::toString);
		System.out.println(compose.apply(new Date()));

	}

}
