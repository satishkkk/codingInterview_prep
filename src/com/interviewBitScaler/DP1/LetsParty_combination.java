package com.interviewBitScaler.DP1;

public class LetsParty_combination {
    static int mod = 10003;
    public static void main(String[] args) {
        int A=3;
        int[] dp = new int[A+1];
        dp[0]=1;
        dp[1]=1;
//        System.out.println(solve_TOP_DOWN(A,dp));
        System.out.println(solve_BOTTOM_UP(A,dp));
    }

    public static int solve_TOP_DOWN(int A,int[] dp) {
        if(A<2) return dp[A];
        if(dp[A] != 0) return dp[A];
//        System.out.println(A);
        dp[A] = ( solve_TOP_DOWN(A-1,dp)%mod + (solve_TOP_DOWN(A-2,dp)*(A-1)) % mod ) % mod;
        return dp[A];
    }

    public int numDecodings(String processed,String remaining) {

        if(remaining.length()==1 && remaining!="0" ) return 1;

        int count =0;

        if(remaining.substring(0,1) !="0"){
            count = numDecodings( processed+remaining.substring(0,1) ,remaining.substring(1) )+1;
        }

        if(remaining.length() >= 1 && processed.length() >= 1 && Integer.parseInt( processed.substring(processed.length()-1) + remaining.substring(0,1) ) >= 26 ){
            count+= 1;
        }
        return count;

    }
    public static int solve_BOTTOM_UP(int A,int[] dp) {
        if(A<2) return dp[A];

        for(int i=2;i<=A;i++){
            dp[i] = ( (dp[i-1])%mod + (dp[i-2]*(i-1))%mod)%mod;
        }
//        System.out.println(A);
//        dp[A] = ( solve_TOP_DOWN(A-1,dp)%mod + (solve_TOP_DOWN(A-2,dp)*(A-1)) % mod ) % mod;
        return dp[A];
    }
}
