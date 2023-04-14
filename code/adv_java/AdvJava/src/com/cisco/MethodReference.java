package com.cisco;

import java.util.function.IntFunction;

public class MethodReference {
    public static void main(String[] args) {

        Appender<String> appender = (str1, str2) -> str1 + " " + str2;
        String append = appender.append("Method", "References");
        System.out.println(append);

        //typeName
        Appender<String> stringAppender = MethodReference::appendMethod; // typeName
        String appendMethod = stringAppender.append("hi", "method refrences");
        System.out.println(appendMethod);

        //objectRef
        MethodReference methodReference = new MethodReference();
        Appender<String> strAppenderObj = methodReference::appendMethodNoneStatic;
        strAppenderObj.append("4","5");
        System.out.println(strAppenderObj);
        
        //arrayTypeName
        IntFunction<int[]> intFunction = int[]::new;
        int[] apply = intFunction.apply(10);

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