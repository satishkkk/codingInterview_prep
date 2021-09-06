package com.interviewBitScaler.Lecture6_BinarySearchApplication;

public class AthMagicalNumber {

    public static void main(String[] args) {
        System.out.println(solve(4,2,3));
    }

    //-----------------------------
    public static int gcd(int x, int y)
    {
        if(x==0) return y;

        return gcd(y%x, x);
    }

    public static int solve(int A, int B, int C) {

        long max = Math.max(A,B);
        long lcm = (long)B*C/gcd(B, C);

        long low = 2, high = (long)(A*max), ans = 2;

        while(low <= high)
        {
            long mid = (high - low)/2 + low;

            // count numbers <= mid divisible by B, C and both B, C.
            long cntB = mid / B, cntC = mid / C, cntBC = mid / lcm;

            if(cntB + cntC - cntBC >= A)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return (int)(ans%(1000*1000*1000 + 7));
    }
//
//    public static int solve(int A, int B, int C) {
//        int mod=(1000*1000*1000)+7;
//        long lcm = (long)((B*C)/ gcd(B,C));
//        long ans=2;
//
//        long low =2;
//        long high = (long)1e15;
//
//        while(low<=high){
//            long mid = low+(high-low)/2;
//            long position = getPosition(B,C,lcm,mid);
//            if(position >= A){
//                ans = mid;
//                high = mid-1;
//            }else{
//                low =mid+1;
//            }
//        }
//        return (int)(ans%mod);
//    }
//
//    public static long getPosition(int B,int C,long lcm, long mid){
//        return (long) ( (mid/B) + (mid/C) - (mid/lcm) );
//    }
//
//    public static int gcd(int a, int b)
//    {
//        if (b == 0)
//            return a;
//        return gcd(b, a % b);
//    }

}
