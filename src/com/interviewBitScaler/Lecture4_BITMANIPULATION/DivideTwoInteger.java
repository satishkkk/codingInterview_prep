package com.interviewBitScaler.Lecture4_BITMANIPULATION;

public class DivideTwoInteger {
    public static void main(String[] args) {
        int x=0, res=0,a=193,b=3;

        for (x = 0; a - (b << x << 1) >= 0; x++){
            res += 1 << x;
            System.out.println("a= "+a);
            System.out.println("b= "+b);
            System.out.println("x= "+x);
            System.out.println("res= "+res);
        }

    }

    public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
}
