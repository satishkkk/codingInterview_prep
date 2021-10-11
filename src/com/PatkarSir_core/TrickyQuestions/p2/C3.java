package com.PatkarSir_core.TrickyQuestions.p2;

public class C3
{
    public static int j;
    public static void m4()
    {
        System.out.println("Entering m4");
        m5();
        System.out.println("Leaving m4");
    }
    static void m5()
    {
        System.out.println("Entering m5");
        com.PatkarSir_core.TrickyQuestions.p1.C2.m2();
        com.PatkarSir_core.TrickyQuestions.p2.p3.C4.m6();
        System.out.println("Leaving m5");
    }
}

