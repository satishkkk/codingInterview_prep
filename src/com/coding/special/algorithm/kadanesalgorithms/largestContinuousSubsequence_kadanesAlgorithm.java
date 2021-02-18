package com.coding.special.algorithm.kadanesalgorithms;

public class largestContinuousSubsequence_kadanesAlgorithm {
    public static void main(int[] args){
        int[] a = {};
        System.out.println("Maximum contigous sum is " + maxSubArraySum(a));
    }

    public static int maxSubArraySum(int[] a){
        int maxSum = 0 ;
        int currentSum = 0;

        for(int i=0 ;i <a.length ; i++ ){
            currentSum = currentSum + a[i];
            maxSum = Math.max(currentSum,maxSum);
//            if(maxSum < currentSum){
//                maxSum = currentSum;
//            }
            //if sum is -ve then make it 0
            if(currentSum < 0){
                currentSum=0;
            }
        }
        return maxSum;
    }
}
