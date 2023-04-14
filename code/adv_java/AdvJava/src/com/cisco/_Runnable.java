package com.cisco;
public class _Runnable {

    public static void main(String[] args) {
        //Imperative Approach
        helloWord();

        //Declarative Approach
        // => runnable no input no output
        Runnable runnable = () -> {
            System.out.println("Hello Word!");
        };

        runnable.run();
    }


    public static void helloWord(){
        System.out.println("Hello Word!");
    }
}