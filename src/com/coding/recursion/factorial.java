package com.coding.recursion;

import java.util.Scanner;

public class factorial {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Factorial is :"+factorial(n));
    }

    static int factorial(int n){
        if(n==0)
            return 1;
        System.out.println("n: "+ n);
        int smallerOutput = factorial(n-1);
        return n*smallerOutput;
    }
}
