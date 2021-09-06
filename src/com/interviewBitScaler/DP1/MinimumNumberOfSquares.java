package com.interviewBitScaler.DP1;

public class MinimumNumberOfSquares {
    public static void main(String[] args) {
        int A=467;
        int[] dp = new int[A+1];
        System.out.println(MinimumNumberOfSquares_TOP_DOWN(A,dp));
    }

    //it will not work for larger input
    static int MinimumNumberOfSquares_TOP_DOWNwithout_dp(int A,int[] dp){
        if(A==0) return 0;
        int out =A;
        for(int i=1;i*i<=A;i++){
            out = Math.min(out,MinimumNumberOfSquares_TOP_DOWNwithout_dp(A-(i*i),dp)+1);
        }
        return out;
    }

    static int MinimumNumberOfSquares_TOP_DOWN(int A,int[] dp){
        if(A==0) return 0;
        if(dp[A]!=0) return dp[A];

        dp[A] =A;
        for(int i=1;i*i<=A;i++){
            dp[A] = Math.min(dp[A],MinimumNumberOfSquares_TOP_DOWN(A-(i*i),dp)+1);
        }
        return dp[A];
    }

    public int countMinSquares_BOTTOM_UP(int A) {
        int[] dp = new int[A+1];

        for(int i=1;i<=A;i++){
            dp[i] = i;
            for(int j=1; j*j<=i; j++){
                dp[i] = Math.min( dp[i] , dp[i-(j*j)]+1);
            }
        }
        return dp[A];
    }

}
