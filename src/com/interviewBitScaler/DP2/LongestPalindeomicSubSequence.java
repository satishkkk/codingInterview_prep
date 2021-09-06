package com.interviewBitScaler.DP2;

public class LongestPalindeomicSubSequence {
    public static void main(String[] args) {
        System.out.println(solve("agbdba"));
    }

    public static int solve(String A) {
        return lps(A,0,A.length()-1);
    }

    public static int lps(String s, int si,int ei){
        if(si==ei) return 1;
        if(si > ei) return 0;

        if(s.charAt(si) == s.charAt(ei)){
            return 2+lps(s,si+1,ei-1);
        }else{
            return Math.max(lps(s,si+1,ei),lps(s,si,ei-1));
        }
    }

}
