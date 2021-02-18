package com.interviewBitScaler.Lecture7_Recursion;

public class A1_test {
    public static void main(String[] args) {
//        solve(3);
        System.out.println(solveTail(3));
        System.out.println(solveTailwithRemove(3,0));
    }

    public static void solve(int n){
        if(n==0)
            return;
        System.out.println(n);
        solve(n-1);
    }

    public static int solveTail(int n){
        if(n==0)
            return 0;
        System.out.println(n);
        return n + solveTail(n-1);
    }

    public static int solveTailwithRemove(int n,int ans){
        if(n==0)
            return ans;
        System.out.println(n);
        return solveTailwithRemove(n-1,ans+n);
    }
}
