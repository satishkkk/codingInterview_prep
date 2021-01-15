package com.coding.recursion.myExperiment;

import java.util.Scanner;

public class findNumberOFDigit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Legth of "+n +" is " + count(n));
    }

    static int count(int n){
//        if ( n==0)
//            return 0;
        if(n%10 == n)
            return 1;

        int smallAns = count(n/10);
        return smallAns+1;
    }
}
