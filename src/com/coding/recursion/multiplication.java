package com.coding.recursion;

public class multiplication {
    public static void main(String[] args) {
        System.out.println(mul(5,3));
    }
    public static int mul(int a,int n){
        if(n==1) return a;

        int sum = mul(a,n-1);

        return a+sum;

    }
}
