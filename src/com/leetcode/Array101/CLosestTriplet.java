package com.leetcode.Array101;

import java.util.Arrays;

public class CLosestTriplet {
    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{1,0,1,1},100));
    }


    public static int searchTriplet(int[] arr, int targetSum) {
        // sort the array
        Arrays.sort(arr); //0 1 1 1
        int n = arr.length;
        int previousDiff = Integer.MAX_VALUE;
        int ans =0;
        for(int i=0;i<n-2;i++){
            int start = i+1;
            int end = n-1;
            while(start < end){
                int diff = targetSum - arr[i] - arr[start] - arr[end]; // 98
                if(diff == 0 ) return diff - targetSum;
                if(Math.abs(previousDiff)> Math.abs(diff) ) {
                    previousDiff = diff;
                    ans = Math.abs(arr[i] + arr[start] + arr[end]);//2
                }
                if(diff < 0 ){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return ans;
    }

}
