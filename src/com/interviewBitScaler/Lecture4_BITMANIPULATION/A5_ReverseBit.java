package com.interviewBitScaler.Lecture4_BITMANIPULATION;

public class A5_ReverseBit {
    public static void main(String[] args) {
        long a = 3;
        System.out.println(reverse(a));
    }

    public static long reverse(long a) {
        long ans = 0;

        for(int i=0;i<32;i++){
            if((a & (1 << i)) != 0 ){
                //i th bit of a is set
                ans = ans | (1 << (31-i)); // make sure to use L because if you not take L then it will take as integer . . .
            }
        }
        return ans;
    }

    public static long reverse1(long a) {
        long rev = 0;

        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            if ((a & (1 << i)) != 0)
                rev |= 1;
        }

        return rev;
    }
}
