package com.company.Core.exceptionhandling;

public class multipleCatch {


    public static void main(String[] args) {
        System.out.println("Welcome to Exception Handling");
        System.out.println("Entering Main ");
        C11.m1();
        System.out.println("Leaving main");
    }

}

class C11 {

    public static void m1() {
        System.out.println("Entering  m1 ");
        C12.m2();
        System.out.println("Leaving  m1 ");
    }
}

class C12 {

    static boolean flag1 =true;
    static boolean flag2 =true;

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
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception caught");
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
        }
        System.out.println("Leaving  m2 ");
    }
}