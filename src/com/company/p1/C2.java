package com.company.p1;

import com.company.p2.*;
import com.company.p2.p3.*;
import static com.company.p2.C3.j;
import static com.company.p1.C1.i;

class C1 {

    public static int i;

    public static void main(String[] args) {
        System.out.println("Entering main");
        i++;
        C3.j++;
        C3.m4();
        m1();
        System.out.println("i = " + i);
        System.out.println("j = " + C3.j);
        System.out.println("Leaving main");
    }

    static void m1() {
        System.out.println("Entering m1");
        i++;
        C3.j++;
        C4.m7();
        System.out.println("i = " + i);
        System.out.println("j = " + C3.j);
        System.out.println("Leaving m1");
    }

}


public class C2 {

    private static int l;

    public static void m2() {
        System.out.println("Entering m2");
        i++;
        j++;
        l++;
        m3();
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("l = " + l);
        System.out.println("Leaving m2");
    }

    static void m3() {
        System.out.println("Entering m3");
        C1.i++;
        C3.j++;
        l++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("l = " + l);
        System.out.println("Leaving m3");
    }
}

