package com.company.Core.inheritance;

public class Explore {

    public static void main(String[] args) {
        System.out.println("Welcome to object composition");
        Test1 test1 = new Test1();
        test1.a=1;
        test1.b=2;
        printC1(test1);

        Test2 test2 = new Test2();
        test2.a=10;
        test2.b=20;
        test2.c=30;
        test2.d=40;
        System.out.println("A"+test2.a);
        System.out.println("B"+test2.b);
        System.out.println("c"+test2.c);
        System.out.println("d"+test2.d);
        printC2(test2);

        C1 a = new C2();
    }

    static void printC1(Test1 o){
        System.out.println(o.toString());
    }

    static void printC2(Test2 o){
        System.out.println(o.toString());
    }

}

class Test1{
    int a;
    int b;

    @Override
    public String toString() {
        return "C1{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

class Test2 extends Test1 {
    int c;
    int d;

    @Override
    public String toString() {
        return "C2{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }


}