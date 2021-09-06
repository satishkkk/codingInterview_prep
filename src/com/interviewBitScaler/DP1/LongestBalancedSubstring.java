package com.interviewBitScaler.DP1;

import java.util.HashMap;
import java.util.Map;

public class LongestBalancedSubstring {
    public static void main(String[] args) {
        System.out.println(LBSlength("[[{()}]]"));
    }

    public static int LBSlength(final String A) {
        Map<Character,Character> pair = new HashMap<>();
        pair.put('(',')');
        pair.put('{','}');
        pair.put('[',']');
        int maxans = 0;
        int n=A.length();
        int[] dp = new int[n];

        for(int i=0;i<n;i++){
            //open braces
//            if( pair.containsKey(A.charAt(i)) ){
//                dp[i]=0;
//            }else if( i-1 >=0){//close braces found
                if( pair.get(A.charAt(i-1)) != null && A.charAt(i) == pair.get(A.charAt(i-1)) ){ //pair found : check if i-1 is open bracket and pair for i?
                    dp[i] = (i>=2 ? dp[i-2] : 0) + 2;
                }else if( pair.get(A.charAt(i-1)) == null // to check if close bracket
                        && (i-dp[i-1]-1) >= 0
                        && pair.get(A.charAt(i-dp[i-1]-1)) != null
                        && pair.get(A.charAt(i-dp[i-1]-1))== A.charAt(i) ){
                    dp[i] = dp[i-1] + 2 + (i-dp[i-1] >=2 ? dp[i-dp[i-1]-2] : 0);
                }
//            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }



}
