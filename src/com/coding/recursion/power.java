package com.coding.recursion;

import java.util.Scanner;

public class power {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x :");
        int x = sc.nextInt();
        System.out.println("Enter n :");
        int n = sc.nextInt();
        System.out.println("Factorial is :"+power(x,n));
    }

    static int power(int x,int n){
        if(n==0)
            return 1;
        int smallAns = power(x, n-1);
        return x* smallAns;
    }


}
