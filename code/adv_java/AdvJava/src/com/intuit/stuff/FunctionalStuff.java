package com.intuit.stuff;

import java.util.function.IntFunction;

import com.kiddcorp.hack.MethodReference;

public class FunctionalStuff {

	public static void main(String[] args) {
		Appender<String> appender = (str1, str2) -> str1 + " " + str2;
		String append=appender.append("method", "references");
		System.out.println(append);
		
		Appender<String> stringAppender=FunctionalStuff::appendMethod;
		String appendMethod= stringAppender.append("hello", "method ref");
		System.out.println(appendMethod);
		
		MethodReference methodRef=new MethodReference();
		Appender<String> strAppenderObj=methodRef::appendMethodNoneStatic;
		System.out.println(strAppenderObj.append("4", "5"));
		System.out.println(strAppenderObj);
		
		IntFunction<int[]> intFunction=int[]::new;
		int[] apply=intFunction.apply(10);
		System.out.println(apply.length);
		

	}

	public static String appendMethod(String str1, String str2) {
		return str1 + " " + str2;
	}

	public String appendMethodNoneStatic(String str1, String str2) {
		return str1 + " " + str2;
	}

	@FunctionalInterface
	public interface Appender<T> {
		T append(T s1, T s2);
	}

}
