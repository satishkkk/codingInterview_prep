package com.PatkarSir_core.metaprogramming;

public class Explore {
    public static void main(String[] args) {
        String str = "hello";

        System.out.println("Getting meta object");

        Class c = str.getClass();
        System.out.println("Str belong to type "+ c.getClass());
        System.out.println(c.getSimpleName());

    }
}
