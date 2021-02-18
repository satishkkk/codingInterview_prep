package com.interviewBitScaler.Lecture3_Maths_GCD;

public class A3_deleteOne {

    public static void main(String[] args) {
        int[] A = new int[] {12,15,18};
        System.out.println(solve(A));
    }
    public static int solve(int[] A) {
        int n = A.length;
        Math.sqrt(16.01);
        if(n==1){
            return -1;
        }

        int[] prefixGCD = new int[n];
        int[] sufixGCD = new int[n];

        prefixGCD[0] =A[0];
        for(int i=1;i<A.length;i++){
            prefixGCD[i] = GCD(A[i] , prefixGCD[i-1]);
        }

        sufixGCD[n-1] =A[n-1];
        for(int i = n-2; i>=0 ; i--){
            sufixGCD[i] = GCD(sufixGCD[i+1],A[i]);
        }

        int max = sufixGCD[1];
        max = Math.max(max,prefixGCD[n-2]);

        for(int i=1 ; i <= n-2;i++){
            max = Math.max(max , GCD(prefixGCD[i-1],sufixGCD[i+1]));
        }
        return max;
    }

    public static int GCD(int a , int b){
        if(a==0)
            return b;
        return GCD(b%a,a);
    }
}

/*
* Delete one
Problem Description

Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.



Problem Constraints
2 <= N <= 105
1 <= A[i] <= 109



Input Format
First argument is an integer array A.



Output Format
Return an integer denoting the maximum value of GCD.



Example Input
Input 1:

 A = [12, 15, 18]
Input 2:

 A = [5, 15, 30]


Example Output
Output 1:

 6
Output 2:

 15


Example Explanation
Explanation 1:


 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.
Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.*/