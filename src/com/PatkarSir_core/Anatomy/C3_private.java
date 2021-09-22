package com.PatkarSir_core.Anatomy;

public class C3_private {
    public static void main(String[] args)

    {

        System.out.println("Hello World");

        m1();

//        C2_private.m2(); // this line will give you an error

        C2_private.m3();

    }

    static void m1()

    {

        System.out.println("m1 of C1");

    }

}



class C2_private

{

    private static void m2()

    {

        System.out.println("m2 of C2");

    }

    static void m3()

    {

        m2();

    }
}
