package com.coding.sorting;

import java.util.Arrays;

/*
*  Best : O(nlog(n)) time | O(log(n)) space
*  Average : O(nlog(n)) time | O(log(n)) space
*  Worst : O(n^2) time | O(log(n)) space
*
* Tip1 : to perform fast try to make sub array of approx same size . . .
* Tip2 : ALways take smaller sub array first and then do bigger sub array . . . recursion tailin will save space
* */
public class A4QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] {8,5,2,9,5,6,3};
        int[] sortedarray = quickSort(arr);
        Arrays.stream(sortedarray).forEach(i -> System.out.println( " " +i));
    }

    public static int[] quickSort(int[] array){
        quickSortHelper(0,array.length-1,array);
        return array;
    }

    public static void quickSortHelper(int start,int end , int[] arr){
        if(start >= end){
            return;
        }
        //TIP1 : use various methods like random , median ,start or end to choose pivot element . . .
        int pivotElement = arr[start];
        int left = start+1;
        int right =end;

        while(left <= right){
            if(arr[left] > pivotElement && arr[right] < pivotElement){
                swap(left , right ,arr);
                left=left+1;
                right=right-1;
            }else if(arr[left] <= pivotElement){
                left= left+1;
            }else if(arr[right] >= pivotElement){
                right=right-1;
            }
        }
        swap(start , right ,arr);

        //TIP2 :  to check if left sub array is smaller
        boolean leftSubarrayIsSmaller = right-1-start < end-(right+1);
        if(leftSubarrayIsSmaller){
            quickSortHelper(start,right-1,arr);
            quickSortHelper(right+1,end,arr);
        }else{
            quickSortHelper(right+1,end,arr);
            quickSortHelper(start,right-1,arr);
        }
    }

    public static void swap(int index1, int index2 , int[] arr){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
