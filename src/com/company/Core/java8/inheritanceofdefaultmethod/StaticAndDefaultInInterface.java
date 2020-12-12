package com.company.Core.java8.inheritanceofdefaultmethod;

public class StaticAndDefaultInInterface implements Right{

    public static void main(String[] args) {
        Right.m2();
        StaticAndDefaultInInterface m = new StaticAndDefaultInInterface();
        m.m2();
    }

    public static void m2(){
        System.out.println("class StaticAndDefaultInInterface : Static Method m2");
    }
}
