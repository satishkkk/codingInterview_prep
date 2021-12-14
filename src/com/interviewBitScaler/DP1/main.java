package com.interviewBitScaler.DP1;

public class main {
    public static void main(String[] args) {
        System.out.println(findMinDays(3,4));
    }
    // Complete the findMinDays function below.
    static int findMinDays(int n, int m) {
         if(n==m) return 0;
        return findDays(n,m,0);
    }

    static int findDays(int n, int m,int ans){
        if(n==m || n==0 || n>1000) return ans;

        findDays(n-1,m,ans+1);
        findDays(n*2,m,ans+1);
        return ans;
    }
}
