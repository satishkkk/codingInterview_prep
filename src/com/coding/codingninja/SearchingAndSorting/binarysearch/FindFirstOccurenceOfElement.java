package com.coding.codingninja.SearchingAndSorting.binarysearch;


import java.util.Arrays;
import java.util.Scanner;

public class FindFirstOccurenceOfElement {

    public static void main(String[] args){
        int[] arr = new int[] { 2,3,4,8,8,8,9,10};
        int result = findFirstOccurence(arr,8);
        if(result==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index : "+ result);
        }
        System.out.println();
    }

    public static int findFirstOccurence(int[] arr , int element){
        int startIdx = 0 ;
        int endIdx = arr.length-1;
        int result = -1;

        while(startIdx <= endIdx){
            int midIdx = (endIdx+startIdx)/2;
            if(arr[midIdx] == element){
                result = midIdx;
                endIdx = midIdx-1;
            }else if( element < arr[midIdx] ){
                endIdx = midIdx-1;
            }else{
                startIdx = midIdx +1;
            }
        }
        return result;
    }

}