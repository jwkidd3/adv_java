package com.cisco;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        //Imperative
        System.out.println(verificationEmail("test"));

        //Declarative
        Predicate<String> predicateEmail = (email) -> email.contains("@");
//        System.out.println(predicateEmail.test("hediyeh@"));

        Predicate<String> predicateExten = str ->  str.contains(".com");
        System.out.println("----*****-----"+predicateEmail.and(predicateExten).test("hediyeh@gmail.com"));

        //negate
        Predicate<Long> evenOrOdd = value -> value %2 ==0;
        System.out.println("Even number: "+evenOrOdd.test(5L));
        System.out.println("Negate Even number: "+evenOrOdd.negate().test(5L));

        Predicate<String> stringPredicate = Predicate.isEqual("Test");
        System.out.println("Is Equal: "+stringPredicate.test("Test4"));



    }

    private static boolean verificationEmail(String email){
        return (email.contains("@")) ? true: false ;
    }
}