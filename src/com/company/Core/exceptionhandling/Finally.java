package com.company.Core.exceptionhandling;

public class Finally {
    public static void main(String[] args) {
        System.out.println("Welcome to Exception Handling");
        System.out.println("Entering Main ");
        C41.m1();
        System.out.println("Leaving main");
    }

}

class C41 {

    public static void m1() {
        System.out.println("Entering  m1 ");
        try {
            System.out.println("Entering try of m1");
            C42.m2();
            System.out.println("Leaving try of m1");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
        } finally {
            System.out.println("finally of m1");
        }
        System.out.println("Leaving  m1 ");
    }
}

class C42 {

    static boolean flag1 ;
    static boolean flag2 = true;

    /*
    * FINALLY WILL EXECUTE IF
    * 1) Try is executed but no error then finally will execute
    * 2) Try is executed and error occured then catch is executed and then finally
    * 3) Try is executed and exception occured but not caught in catch block so before propgating to caller it will execute finally
    */
    public static void m2() {
        System.out.println("Entering  m2 ");
        try {
            System.out.println("Entering try of m2");
            if (flag1) {
                int a = 1, b = 2, c = 0;
                a = b / c;
            }
            System.out.println("Median of m2");
            if (flag2) {
                int[] b = new int[10];
                b[19] = 22;
            }
            System.out.println("Leaving try of m2");
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught");
        } finally {
            System.out.println("finally of m2");
        }
        System.out.println("Leaving  m2 ");
    }
}
