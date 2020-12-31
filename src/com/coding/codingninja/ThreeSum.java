package com.coding.codingninja;

import java.util.Arrays;

//Time O(N^2) | Space O(N)
//Constarain : input array should have unique elements
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        int sum =0;
        int pairCount =tripletSum(arr,sum);
        System.out.println("Triplet Count is :"+pairCount);
    }

    public static int tripletSum(int[] arr, int num) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        Arrays.sort(arr);
        int tripletCout =0;
        int leftIndex,rightIndex,currentSum;
        for(int i=0; i< arr.length-2;i++){
            leftIndex=i+1;
            rightIndex=arr.length-1;
            while(leftIndex<rightIndex){
                currentSum = arr[i]+arr[leftIndex]+arr[rightIndex];
                if(currentSum==num){
                    tripletCout++;
//                    int leftValue = arr[leftIndex];
//                    while(leftIndex<arr.length && arr[leftIndex] == leftValue){
//                        leftIndex++;
//                    }
//                    int rightValue = arr[rightIndex];
//                    while(rightIndex>leftIndex && arr[rightIndex] == rightValue){
//                        rightIndex--;
//                    }
                    leftIndex++;
                    rightIndex--;
                }else if(currentSum < num){
                    leftIndex++;
                }else if((currentSum > num)){
                    rightIndex--;
                }
            }
//            while(i+1 < arr.length && arr[i] == arr[i+1]){
//                ++i;
//            }
        }
        return tripletCout;
    }
}
