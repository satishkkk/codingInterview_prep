package com.company.recursion;

public class A3_ReverseString_fibonaci {

    String reverse(String s){
        if(s.length()==0)
            return s;
        return reverse(s.substring(1,s.length()))+ s.substring(0,1);
    }

    int fibo(int n){

        if(n==0) return 0;
        if(n==1) return 1;

        int t1 = fibo(n-1);
        int t2 = fibo(n-2);

        return t1+t2;
    }


    public static void main(String[] args) {
        A3_ReverseString_fibonaci obj = new A3_ReverseString_fibonaci();
        String s ="asad";
        System.out.println(obj.reverse(s));

        int n =5;
        System.out.println("Fibonaci "+ obj.fibo(35));
    }
}
