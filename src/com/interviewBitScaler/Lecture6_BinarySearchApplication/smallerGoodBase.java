package com.interviewBitScaler.Lecture6_BinarySearchApplication;

import java.math.BigInteger;

public class smallerGoodBase {

    public static void main(String[] args) {
        System.out.println(solve("6"));
    }

    public static String solve(String A) {

        BigInteger NUM = new BigInteger(A);

        int maxDigits = (int)Math.ceil(Math.log(1e18)/Math.log(2));
        int minDigits = 2;
        // why we starting from a xvalue?
        // because base is inversly proprtional to no of digits. . .so to get minimum base we have to start with maximum no of digits which 62 in our case
        for(int i = maxDigits ; i>minDigits ;i--){
            //GP = for i number of digit we have to find minimum base(mid) for value " n "
            // n(mid-1) = mid^i -1 if true return mid
            // if lhs > rhs  increase mid
            //else decrease mid
            long start = 2;
            long end = Long.parseLong(A);

            while(start<=end){
                long mid = (start+end)/2;
                BigInteger lhs = NUM.multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));
                BigInteger rhs = (BigInteger.valueOf(mid).pow(i)).subtract(BigInteger.ONE);
                int cmp = lhs.compareTo(rhs);

                if(lhs.equals(rhs)) return mid+"";
                if(cmp > 0 ){
                    start = mid+1;
                }else{
                    end =mid-1;
                }
            }
        }
        return Long.parseLong(A)-1+"";  // worst case if no base found then base will be n-1 why ???
        //because  n = (base^1) + 1  . . .so base will be n-1
    }
}
