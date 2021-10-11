package com.PatkarSir_core.exceptionhandling.userdefinedexception;

public class Exceptionhandling {

    public static void main(String[] args) {
        System.out.println("Welcome to Exception Handling");
        System.out.println("Entering Main ");
        C1.m1();
        System.out.println("Leaving main");
    }

}

class C1 {

    public static void m1() {
        System.out.println("Entering  m1 ");
        try {
            System.out.println("Entering try of m1");
            C2.m2();
            System.out.println("Leaving try of m1");
        } catch (E2 e) {
            System.out.println("E2 caught with error " +
                    e.getErrorInfo());
        } finally {
            System.out.println("finally of m1");
        }
        System.out.println("Leaving  m1 ");
    }
}

class C2 {

    static boolean flag1 ;
    static boolean flag2 =true;

    public static void m2() {
        System.out.println("Entering  m2 ");
        try {
            System.out.println("Entering try of m2");
            if (flag1) {
                E1 e1 = new E1("error1");
                throw e1;
            }
            System.out.println("Median of first try");
            if (flag2) {
                throw new E2("error2");
            }
            System.out.println("Leaving   try of m2");
        } catch (E1 e) {
            System.out.println("E1 Caught with error " +
                    e.getErrorInfo());
        } finally {
            System.out.println("finally of m2");
        }
        System.out.println("Leaving  m2 ");
    }
}

class E1 extends RuntimeException {

    private String errorInfo;

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public E1(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}

class E2 extends RuntimeException {

    private String errorInfo;

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public E2(String errorInfo) {
        this.errorInfo = errorInfo;
    }

}
