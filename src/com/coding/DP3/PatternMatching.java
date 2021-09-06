package com.coding.DP3;
public class PatternMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("ab",".*"));
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int isMatch(final String A, final String B) {

        int m = A.length();
        int n = B.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0]=true;

        for(int i=1;i<=n;i++){
            if(B.charAt(i-1) == '*' && dp[0][i-1]) dp[0][i]=true;
        }

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    continue;
                }else if(A.charAt(i-1) == B.charAt(j-1) || B.charAt(j-1) == '?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(B.charAt(j-1) == '*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n]==true ? 1 :0;
    }
}

/*
* Regular Expression Match
Problem Description

Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).



Problem Constraints
1 <= length(A), length(B) <= 104



Input Format
The first argument of input contains a string A.
The second argument of input contains a string B.



Output Format
Return 1 if the patterns match else return 0.



Example Input
Input 1:

 A = "aaa"
 B = "a*"
Input 2:

 A = "acz"
 B = "a?a"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 So, the pattern matches we return 1.
Explanation 2:

 '?' matches any single character. First two character in string A will be match.
 But the last character i.e 'z' != 'a'. Return 0.

* */

