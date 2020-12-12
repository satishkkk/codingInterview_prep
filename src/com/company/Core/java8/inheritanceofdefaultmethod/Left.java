package com.company.Core.java8.inheritanceofdefaultmethod;

public interface Left {

    public default void m1(){
        System.out.println("HELLO FROM INTERFACE LEFT.m1()");
    }
}
