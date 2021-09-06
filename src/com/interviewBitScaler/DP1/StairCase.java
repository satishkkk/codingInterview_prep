package com.interviewBitScaler.DP1;

public class StairCase {
    public static void main(String[] args) {
        System.out.println(climbStairs_BOTTOM_UP(5));
        System.out.println(climbStairs_TOP_DOWN(5,new int[6]));
    }

    public static int climbStairs_TOP_DOWN(int A,int[] dp){
        if(A<=2) return A;

        if(dp[A] != 0) return dp[A];

        dp[A] = climbStairs_TOP_DOWN(A-1,dp)+climbStairs_TOP_DOWN(A-2,dp);

        return dp[A];
    }

    public static int climbStairs_BOTTOM_UP(int A) {
        if(A<3) return A;

        int[] dp = new int[A+1];
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=A;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[A];
    }
}
