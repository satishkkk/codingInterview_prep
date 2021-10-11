package com.PatkarSir_core.Anatomy;

public class C1 {

    public static void main(String[] args) {
        System.out.println("Hello World");
        m1();
        C2.m2();
    }

    static void m1() {
        System.out.println("m1 of C1");
    }
}


    class C2 {

    static void m2() {

        System.out.println("m2 of C2");

    }

}
