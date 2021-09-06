package com.coding.DP3;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(solve("ccdbaeeceecabaacebcaebdceaacdcdcbbadcebcaaceaebcdacccaedcbccacedaacdbaaeacdbeedccceeabececcc"));
    }

    public static int solve(String A) {
        return helper(A,0,A.length()-1);
    }

    public static int helper(String A,int si,int ei){
        if(si==ei) return 1;
        if(si>ei) return 0;

        if(A.charAt(si) == A.charAt(ei)) return 2+helper(A,si+1,ei-1);
        else return Math.max( helper(A,si+1,ei),helper(A,si,ei-1) );
    }
}
