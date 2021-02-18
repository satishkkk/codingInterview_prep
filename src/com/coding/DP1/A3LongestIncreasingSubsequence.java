package com.coding.DP1;

import java.io.Console;

public class A3LongestIncreasingSubsequence {

//    TIME : O(N^2) | SPACE: O(N)
    static int lis (int[] a , int size){
        int[] out = new int[size];
        out[0]=1;
        int max =0;

        for(int i=1;i<size;i++){
            int possibleCandidate=0;
            for(int j = i-1;j>=0;j--){
                if(a[i]>a[j]){
                    possibleCandidate =Math.max(possibleCandidate,out[j]);
                }
            }
            out[i]=possibleCandidate+1;
            max= Math.max(max,out[i]);
        }
        return max;
    }



    public static void main(String[] args) {
        int arr[] = { 5,8,3,7,9,1};
        int n = arr.length;
        System.out.println("Length of lis is "
                + lis(arr, n) + "\n");
    }

}
