package com.coding.DP3;
/*https://leetcode.com/problems/regular-expression-matching/solution/*/

enum Result { // why enum ? because we cant compare boolean value with null and hence we need some other mechanism
    TRUE, FALSE
}

public class Patternmatching2 {
    static Result[][] memo;

    public static void main(String[] args) {
        System.out.println(isMatch("aab","c*a*b*"));
    }

    public static boolean isMatch(String s, String p) {
        // return isMatchHelper(s,p);
//        return isMatchHelperMemo(s,p);
            return isMatchHelperbottomUp(s,p);
    }


    //Recursive solution brute force
    public static  boolean isMatchHelper(String text,String pattern){
        if(pattern.isEmpty()) return text.isEmpty();

        boolean first_match = (!text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.'));

        if(pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (
                    isMatchHelper(text,pattern.substring(2)) || //do not consider *
                            (first_match && isMatchHelper(text.substring(1),pattern)) //consider star and previous character
            );
        }else{
            return first_match && isMatchHelper(text.substring(1),pattern.substring(1) );
        }
    }

    //Recursive with memoziation top down
    public static boolean isMatchHelperMemo(String text,String pattern){
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public static boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        // if pattern is end and text is also end then return true
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    // bottom up
    //https://leetcode.com/problems/regular-expression-matching/discuss/191830/Java-DP-solution-beats-100-with-explanation
    public static boolean isMatchHelperbottomUp(String text,String pattern){
        int m = text.length();
        int n = pattern.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j=1; j<= n;j++){
            if(pattern.charAt(j-1) == '*') dp[0][j] = dp[0][j-2];
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if(pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2] // consider '*' as empty string
                            || ((text.charAt(i-1) == pattern.charAt(j-2) || pattern.charAt(j-2) == '.') && dp[i-1][j]); // '*'' ke aage wala charcxter same hai ya '.' hai
                    //pattern.charAt(j-2) matlab '* ke aage wala character'
                }
            }
        }
        return dp[m][n];
    }

}
