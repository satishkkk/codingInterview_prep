package com.company.linkedin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) {
//        File file = new File("2.txt");
//        file.getName();
//        System.out.println(readAllBytesJava7("abc.txt"));
        String str = "abc.c";
        String[] s = str.split("\\.");
        System.out.println(s[0]);
        System.out.println(s[1]);
    }

    private static String readAllBytesJava7(String filePath)
    {
        String content = "";

        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return content;
    }

    public static int minInsertions(String s) {
        String sReverse = new StringBuilder(s).reverse().toString();
        int lcs = longestCommonSubsequence(s.toCharArray(), sReverse.toCharArray());
        return s.length() - lcs;
    }

    private static int longestCommonSubsequence(char[] arr1, char[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

}
