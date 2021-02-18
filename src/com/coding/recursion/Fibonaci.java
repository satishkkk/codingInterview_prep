package com.coding.recursion;

import java.util.Scanner;

public class Fibonaci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Fibonachi is :"+fibo(n));
    }

    static int fibo(int n){
        if(n==1 ){
            return 0;
        }else if(n==2){
            return 1;
        }else{
            int a = fibo(n-1);
            int b = fibo(n-2);

//            System.out.println(a+b + " ");
            return a+b;
        }
    }
}
