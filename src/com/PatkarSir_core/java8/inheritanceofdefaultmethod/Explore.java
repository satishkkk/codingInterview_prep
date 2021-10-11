package com.PatkarSir_core.java8.inheritanceofdefaultmethod;

//if you implements both the interface which containse same default method m1() then in your class you have to compulsorily implements m1() method
public class Explore implements Left,Right{

    public static void main(String[] args) {
        System.out.println("test");
        Explore e = new Explore();
        e.test();
    }

    void test(){
        Left.super.m1();
        Right.m2();
        m2();
    }


    @Override
    public void m1(){
        System.out.println("HELLO FROM CLASS Explore.m1()");
    }

    public static void m2(){
        System.out.println("class Explore : Static Method m2");
    }
}
