package com.coding.recursion;

public class A2_fctorial {

    int factorial(int n){
        if(n==0){
            return 1;
        }

        return n*factorial(n-1);

    }

    public static void main(String[] args) {
        A2_fctorial obj = new A2_fctorial();
        int n =7;
        System.out.println(obj.factorial(n));
    }

}
