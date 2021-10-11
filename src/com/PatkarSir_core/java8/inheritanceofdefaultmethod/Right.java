package com.PatkarSir_core.java8.inheritanceofdefaultmethod;

public interface Right {

    public default void m1(){
        System.out.println("HELLO FROM INTERFACE RIGHT.m1()");
    }

    //static method of interface can not be inherited by implemnting class or sub interface
    public static void m2(){
        System.out.println("class Right : Static Method m2");
    }
}
