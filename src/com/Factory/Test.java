package com.Factory;

public class Test {
    public static void main(String args[]){
       int[] arr= new int[]{4,2,45,6,48,8};
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
       quicksort(arr,0,arr.length-1);
        System.out.println("SORTING :");
       for(int i=0;i<arr.length;i++){
           System.out.println(arr[i]);
       }
    }

    //4,2,45,6,7|,8
//    ^        ^
//    4,2,
//    ,7,6,| 45
    public static void quicksort(int[] arr,int start,int end){
        int pivot = arr[end];
        int pivotIndex= end;
        if(end<=0 || start<0 || start > end ) return;

        int left = start;
        int right = end-1;

        for( left=start;left<right;){
            if(arr[left] < pivot){
                left++;
                continue;
            }else{
                swap(arr,left,right--);
            }
        }
        int index= right+1;
        swap(arr,index,pivotIndex);

        quicksort(arr,start,index-1);
        quicksort(arr,index+1,end);
    }

    static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] =temp;
    }
}
