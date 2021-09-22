package com.PatkarSir_core.exceptionhandling.userdefinedexception;

public class CheckedExceptions {
    public static void main(String[] args) {
        System.out.println("Welcome to Exception Handling");
        System.out.println("Entering Main ");
        try {
            System.out.println("Entering try of main");
            C11.m1();
            System.out.println("Leaving try of main");
        } catch (E12 e) {
            System.out.println("E2 caught with error " + e.getErrorInfo());
        } finally {
            System.out.println("finally of main");
        }
        System.out.println("Leaving main");
    }

}

class C11 {

    public static void m1() throws E12 {
        System.out.println("Entering  m1 ");
        C12.m2();
        System.out.println("Leaving  m1 ");
    }
}

class C12 {

    static boolean flag1;
    static boolean flag2;

    public static void m2() throws E12 {
        System.out.println("Entering  m2 ");
        try {
            System.out.println("Entering try of m2");
            if (flag1) {
                E11 e1 = new E11("error1");
                throw e1;
            }
            System.out.println("Median of first try");
            if (flag2) {
                throw new E12("error2");
            }
            System.out.println("Leaving   try of m2");
        } catch (E11 e) {
            System.out.println("E11 Caught with error " + e.getErrorInfo());
        } finally {
            System.out.println("finally of m2");
        }
        System.out.println("Leaving  m2 ");
    }
}

class E11 extends Exception {

    private String errorInfo;

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public E11(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}

class E12 extends Exception {

    private String errorInfo;

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public E12(String errorInfo) {
        this.errorInfo = errorInfo;
    }

}
