package com.cisco;
public class Lambda {
    public static void main(String[] args) {
        StringToInt stringToInt = (String str) -> str.length();//String::length
        Integer length = stringToInt.map("Hi Lambda!");
        System.out.println("Length: "+length);
    }

    @FunctionalInterface
    public interface StringToInt {
        Integer map(String str);
    }
}