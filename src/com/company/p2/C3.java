package com.company.p2;

import com.company.p1.*;
import com.company.p2.p3.*;

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
        com.company.p1.C2.m2();
        com.company.p2.p3.C4.m6();
        System.out.println("Leaving m5");
    }
}

