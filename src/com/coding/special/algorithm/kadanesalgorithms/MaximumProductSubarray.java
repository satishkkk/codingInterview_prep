package com.coding.special.algorithm.kadanesalgorithms;

public class MaximumProductSubarray {

    public static void main(String[] args) {

        int[] arr = {5,3,-1,3};
        System.out.println("Get maximum product subarray :" + maxProductOfSubarray(arr));
    }

    public static int maxProductOfSubarray(int[] arr){
        int max_so_far = 0;
        int max_ending_here = 1;
        int min_ending_here = 1;

        for(int i =0 ; i < arr.length ; i++ ){
            if(arr[i] > 0){
                max_ending_here = max_ending_here*arr[i];
                /* min_ending_here can be 1 , if all the previous elements are +ve , hence min of both the needed */
                min_ending_here = Math.min(1, min_ending_here*arr[i]);
            }else if(arr[i] == 0){
                max_ending_here = 1 ;
                min_ending_here = 1;
            }else if(arr[i] < 0){
               /*min_ending_here can be 1 or -ve, if all the previous elements are +ve ,
                hence min_ending_here will be 1 and hence multiplying it with -ve number will make it less
               however we are caluclating max hence we have to be cautious here.*/
                int temp = max_ending_here;
                max_ending_here = Math.max(1,min_ending_here*arr[i]); // max can be 1 and ir can not be -ve hence . . .
                min_ending_here = temp*arr[i];
            }
            max_so_far = Math.max(max_so_far,max_ending_here);
        }
        return max_so_far;
    }
}
