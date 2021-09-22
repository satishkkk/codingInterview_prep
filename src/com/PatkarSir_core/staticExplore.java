package com.PatkarSir_core;

public class staticExplore {
    public static void main(String[] args) {
        C1 obj1 = new C1();
        C1.printC1();
        obj1.a=10;
        obj1.printC1(); // you can access static member of class with object also
    }
}

class C1{
    static int a;
    static int b;

    static void printC1(){
        System.out.println(a);
        System.out.println(b);
    }
}

class C2 extends C1{
    static int a;
    static int b;
    static int c;
    static int d;
    static void printC(){
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }
}