package com.coding.DP1;

import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// looks similar to A5StairCaseproblem but its not why ? ? ?
// in staircase 1,1,2 and 1,2,1 is different but
// in case of coin change 1,1,2 and 1,2,1 is same . . .Think about it
public class A6CoinChangeProblem {

    // Recursive way
    public static int countWaysToMakeChange(int denominations[], int n){
        if(n==0){
            return 1; //tu bhi muje kuch mat de mai bhi tujhe kuch nahi dega ->so 1 way
        }
        if(denominations.length==0){
            return 0;// no coins so 0 ways
        }
        if(n < 0){
            return 0; //VERY IMP - if n goes negative while reducing value of n then return 0 . . .
        }

        //include first coin . . hence n will be reduce by value of coin (0 th element of denomination)
        int left = countWaysToMakeChange(denominations,n-denominations[0]);
        //do not include first coin . . remove first coin from the denomination array . . since we are not including that coin hence we do not reduce value of n
        int right = countWaysToMakeChange(Arrays.copyOfRange(denominations,1,denominations.length),n);

        return left+right;
    }

    // MEMOTIZATION
    public static int countWaysToMakeChangeDP(int denominations[], int value,int[][] output){
        if(value==0){
            return 1;
        }

        if(denominations.length==0){
            return 0;
        }

        if(value < 0){
            return 0;
        }

        if(output[value][denominations.length] >-1){
            return output[value][denominations.length];
        }

        int left = countWaysToMakeChange(denominations,value-denominations[0]); //reducing value by 1 st element
        int right = countWaysToMakeChange(Arrays.copyOfRange(denominations,1,denominations.length),value);

        output[value][denominations.length] = left+right;

        return left+right;
    }

    public static int countWaysToMakeChangedp(int denominations[], int value){
        int coinsLength = denominations.length;
        int dp [][] = new int[value+1][coinsLength];

        for(int i=0;i<coinsLength;i++){
            dp[0][i] =1;
        }

        for (int i = 1; i < value+1; i++) {
            for (int j = 0; j < coinsLength; j++) {
                //count of solutions including denominations[j]
                int x = (i-denominations[j]>=0) ? dp[i- denominations[j]][j]:0;
                //count of solutions excluding denominations[j]
                int y = (j>=1) ? dp[i][j-1] : 0;

                dp[i][j] = x+y;
            }
        }
        return dp[value][coinsLength-1];
    }

    public static int countWaysToMakeChangeIterative(int denominations[], int value){
        int n = denominations.length;
        int ways [][] = new int[n][value+1];

        for(int i=0;i<n;i++){
            ways[i][0] =1;
        }

        for(int i=n-1 ; i>=0 ; i--){
            for(int j=1 ;j <= value ; j++){

                int count1 = 0;
                if(i+1 <= n-1){
                    count1 = ways[i+1][j];
                }

                int count2 =0;
                if(j- denominations[i] >=0){
                    count2 = ways[i][j-denominations[i]];
                }

                ways[i][j] = count1+count2;
            }
        }
        return ways[0][value];
    }



    public static void main(String[] args) {
        //1,1,1,1
        //1,1,2
        //2,2
        int n = 4;
        int[] denomination = new int[]{1,2};

        System.out.println(countWaysToMakeChange(denomination,n));

        int[][] output = new int[n+1][denomination.length+1];

        for(int[] row : output)
            //TODO : Look this function Arrays.fill. . . . .
            Arrays.fill(row,-1);
//        for(int i=0;i<output.length;i++){
//            for(int j=0;j<output[i].length;j++){
//                output[i][j] =-1;
//            }
//        }
        System.out.println(countWaysToMakeChangeDP(denomination,n,output));
        System.out.println(countWaysToMakeChangeIterative(denomination,n));
        System.out.println(countWaysToMakeChangedp(denomination,n));
    }

}

/*
* Coin Change Problem
Send Feedback
For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.
Return 0 if the change isn't possible.
Input Format
The first line of the input contains an integer value N, which denotes the total number of denominations.

The second line of input contains N values, separated by a single space. These values denote the value of denomination.

The third line of the input contains an integer value, that denotes the value of V.
Output Format
Print the total total number of ways i.e. W.
Constraints :
1 <= n <= 10
1 <= V <= 1000

Time Limit: 1sec
Sample Input 1 :
3
1 2 3
4
Sample Output 1 :
4
Explanation to Sample Input 1 :
Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
Sample Input 2 :
6
1 2 3 4 5 6
250
Sample Output 2 :
13868903
*
* */