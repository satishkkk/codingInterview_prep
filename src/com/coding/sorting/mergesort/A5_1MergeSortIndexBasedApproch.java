package com.coding.sorting.mergesort;

import java.util.Arrays;
// WORST: O(nlog(n)) time | O(nlog(n)) space
public class A5_1MergeSortIndexBasedApproch {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7,8};
        mergeSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    static void mergeSort(int[] arr,int startidx,int endIdx){
        //base case
        if(startidx >= endIdx)
            return;

        int midIdx = (startidx+endIdx)/2;

        //hypothesis that left and right index is sorted
        mergeSort(arr,startidx,midIdx);
        mergeSort(arr,midIdx+1,endIdx);

        //Induction
        merge(arr,startidx,midIdx+1,endIdx);
    }

    static void merge(int[] arr,int startIdx,int midIdx,int endIdx){
        int[] temp = new int[endIdx-startIdx+1];

        int i = startIdx;
        int j = midIdx;
        int k = 0;

        while(i < midIdx && j <= endIdx) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i<midIdx){
            temp[k++] = arr[i++];
        }

        while(j<=endIdx){
            temp[k++] = arr[j++];
        }

        int l=0;
        for(int m=startIdx; m<=endIdx; m++,l++){
            arr[m]=temp[l];
        }

    }

}
