package com.PatkarSir_core.exceptionhandling;

public class escapeCondition {
    public static void main(String[] args) {
        System.out.println("Welcome to Exception Handling");
        System.out.println("Entering Main ");
        C71.m1();
        System.out.println("Leaving main");
    }

}

class C71 {

    public static void m1() {
        System.out.println("Entering  m1 ");
        try {
            System.out.println("Entering try of m1");
            C72.m2(1);
            C72.m2(11);
            C72.m2(16);
            System.out.println("Leaving try of m1");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
        } finally {
            System.out.println("finally of m1");
        }
        System.out.println("Leaving  m1 ");
    }
}

class C72 {

    static boolean flag1;
    static boolean flag2;
    static boolean flag3;
    static boolean flag4;

    public static void m2(int v) {
        System.out.println("Entering  m2 ");
        try {
            System.out.println("Entering first try of m2");
            if (flag1) {
                int a = 1, b = 2, c = 0;
                a = b / c;
            }
            System.out.println("Median of first try");
            for (int i = 0; i < 3; i++) {
                System.out.println("Iteration "+ i + " of for loop");
                try {
                    System.out.println("Entering second try of m2");
                    if (flag3) {
                        int a = 1, b = 2, c = 0;
                        a = b / c;
                    }
                    System.out.println("Median of second try");
                    if (flag4) {
                        int[] b = new int[10];
                        b[19] = 22;
                    }
                    if ( v > 15){
                        System.exit(0);// finally will not call
                    }
                    if ( v > 10){
                        break;//lfinally will call
                    }
                    if( i > v){
                        return;// finally will call
                    }
                    System.out.println("Leaving second try of m2");
                } catch (ArithmeticException e) {
                    System.out.println("ArithmeticException caught");
                } finally {
                    System.out.println("second finally of m2");
                }
            }
            if (flag2) {
                int[] b = new int[10];
                b[19] = 22;
            }
            System.out.println("Leaving first try of m2");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException Caught");
        } finally {
            System.out.println("first finally of m2");
        }
        System.out.println("Leaving  m2 ");
    }
}
