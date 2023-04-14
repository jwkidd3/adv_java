package com.kiddcorp.hack;

public class MethodReference {

	public static void main(String[] args) {
		Appender<String> appender=(str1,str2) -> str1 + " - " + str2;
		String appendRes=appender.append("method","Reference");
		System.out.println(appendRes);
		
		Appender<String> stringAppender = MethodReference::appendMethod;
		String appMthd=stringAppender.append("One", "two");
		System.out.println(appMthd);
		
		Appender<String> appendObj=new MethodReference()::appendMethodNoneStatic;
		System.out.println(appendObj.append("sixe", "seven"));
		System.out.println(appendObj);

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
