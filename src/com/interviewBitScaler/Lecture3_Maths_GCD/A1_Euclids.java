package com.interviewBitScaler.Lecture3_Maths_GCD;

public class A1_Euclids {
    public static void main(String[] args) {
        System.out.println(gcd(4, 1));
    }

    public static int gcd(int A, int B) {
        if (A == 0)
            return B;

        return gcd(B % A, A);

    }
}
