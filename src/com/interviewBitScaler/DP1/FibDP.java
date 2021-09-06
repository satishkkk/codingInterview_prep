package com.interviewBitScaler.DP1;

public class FibDP {

    public static void main(String[] args) {
        int n = 5;
        int[] out = new int[n+1];
        System.out.println(fib_TOP_DOWN(n,out));
    }

/// TOP_DOWN APPROCH
    public static int fib_TOP_DOWN(int n,int[] out){
        if (n<2) return n;

        if(out[n] >0) return out[n];

        out[n] = fib_TOP_DOWN(n-1,out)+fib_TOP_DOWN(n-2,out);

        return out[n];
    }

    /// BOTTOM_UP APPROCH
    public static int fib_BOTTOM_UP(int n,int[] out){
        out[1]=1;
        out[0]=0;

        for(int i=2;i<=n;i++){
            out[i] = out[i-1]+out[i-2];
        }
        return out[n];
    }
}
