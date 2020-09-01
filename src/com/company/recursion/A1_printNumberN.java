package com.company.recursion;

public class A1_printNumberN {

    void printNumber(int n){
        //Base Condition
        if (n==1){
            System.out.println(n);
            return;
        }
        //hypothesis
        printNumber(n-1);
        //Interception
        System.out.println(n);
    }

    void printReverseNumber(int n){
        //Base Condition
        if (n==1){
            System.out.println(n);
            return;
        }
        //Interception
        System.out.println(n);
        //hypothesis
        printNumber(n-1);

    }

    public static void main(String[] args) {
        A1_printNumberN obj = new A1_printNumberN();
        int n =7;
        obj.printNumber(n);
        System.out.println("REVERSE NUKBER :");
        obj.printReverseNumber(n);
    }
}
