package com.interviewBitScaler.Lecture5_BinarySearch;


public class Staircase {
    public static void main(String[] args) {
        System.out.println(solve(20));
    }
    public static int solve(int A) {
        if(A==0) return 0;

        long low =0;
        long high = A;

        long ans = 0;

        while(low<=high){
            long mid = low + high/2;
            if(isValid(mid,(long)A)){
                ans = Math.max(ans , mid);
                low =mid+1;
                System.out.println("ans:"+ans);
            }else{
                System.out.println("mid:"+ans);
                high = mid-1;
            }
        }
        return (int)ans;
    }

    public static boolean isValid(long out,long A){
        return (out * (out+1))/2 <= A;
    }
}
