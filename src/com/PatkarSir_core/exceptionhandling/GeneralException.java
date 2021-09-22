package com.PatkarSir_core.exceptionhandling;

public class GeneralException {

    public static void main(String[] args) {
        System.out.println("Welcome to Exception Handling");
        System.out.println("Entering Main ");
        C31.m1();
        System.out.println("Leaving main");
    }

}

class C31 {

    public static void m1() {
        System.out.println("Entering  m1 ");
        C32.m2();
        System.out.println("Leaving  m1 ");
    }
}

class C32 {

    static boolean flag1 = true;
    static boolean flag2;

    public static void m2() {
        System.out.println("Entering  m2 ");
        try {
            System.out.println("Entering try");
            if (flag1) {
                int a = 1, b = 2, c = 0;
                a = b / c;
            }
            System.out.println("Median");
            if (flag2) {
                int[] b = new int[10];
                b[19] = 22;
            }
            System.out.println("Leaving try");
        } catch (RuntimeException e) {
            System.out.println("Exception Caught");
        }
        System.out.println("Leaving  m2 ");
    }
}
