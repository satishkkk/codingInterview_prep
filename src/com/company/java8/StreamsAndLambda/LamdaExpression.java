package com.company.java8.StreamsAndLambda;

public class LamdaExpression {


    public static void main (String args[]) {
        System.out.println("hello world");

        myLambda greetingFunction = () -> System.out.println("Hello again");
        greetingFunction.foo();
//        multiplyInt =(int a) -> a*2;
//         addNumber = (int a, int b) -> a+b;
//        safeDivide = (int p, int q ) -> {
//            if (q==0) return 0;
//            return p/q;
//        };
//
//        stringLebgth = (String s) -> s.length();
    }
}

interface myLambda{
    void foo();
}

interface myAdd{
    int add(int a,int b);
}
