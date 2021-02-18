package com.interviewBitScaler.Lecture4_BITMANIPULATION;

import java.util.ArrayList;

public class A3_DifferentBitSumPairwise {
    public static void main(String[] args) {

    }

    public int cntBits(int[] A) {
        long ans = 0;
        int mod = 1000*1000*1000+7;
        long zerosCount = 0;

        for(int i=0 ;i <31 ;i++){
            zerosCount=0;
            for(int j=0;j<A.length;j++){
                if(A[j] % 2 == 0)
                    zerosCount++;
                A[j] = A[j] >> 1;
            }
            ans = ans + (zerosCount*(A.length-zerosCount)*2) % mod;
            ans %= mod;
        }

        return (int)ans;
    }

    //BRUTE FORCE : O(N^2)
    public static int cntBits1(ArrayList<Integer> A) {
        int count =0;
        int mod = (int)Math.pow(10,9)+7;
        for(int i=0;i<A.size()-1;i++){
            for(int j=i+1;j<A.size();j++){
                count += countSetBit(A.get(i),A.get(j)) % mod;
            }
        }
        return count*2;
    }

    public static int countSetBit(int a, int b){
        int x= a^b;
        int count =0;
        while(x!=0){
            x &= x-1;
            count++;
        }
        return count;
    }
}

/*
* Different Bits Sum Pairwise
Problem Description

We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 231 - 1



Input Format
First and only argument of input contains a single integer array A.



Output Format
Return a single integer denoting the sum.



Example Input
Input 1:

 A = [1, 3, 5]
Input 2:

 A = [2, 3]


Example Output
Ouptut 1:

 8
Output 2:

 2


Example Explanation
Explanation 1:

 f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5)
 = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
Explanation 2:

 f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2*/