package com.coding.sorting;

import java.util.Arrays;
// O(n^2) time | O(1) Space

/* CARD GAME : pick one by one and insert the number  .. . assume 1 st element is sorted */

// assume : initial array is sorted array
public class A3InsertionSortMain {

    public static int[] InsertionSort1(int[] array){
        if(array.length == 0)
            return array;

        int j;
        for(int i=1 ; i<array.length ; i++){
            j =i;
            while(j>0 && array[j] < array[j-1]){
                swap(j,j-1,array);
                j-=1;
            }
        }
        return array;
    }

    public static int[] InsertionSort(int[] array){
        if(array.length==0)
            return new int[] {};

        for(int i=1; i<array.length ; i++){
            int current = array[i];
            int j;
            for(j= i-1 ; j >= 0 ; j--){
                if(current < array[j]){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = current;
        }
        return array;
    }



    public static void swap(int i,int j,int[] array){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {8,5,2,9,5,6,3};
        int[] sortedarray = InsertionSort(arr);
        Arrays.stream(sortedarray).forEach( i -> System.out.println( " " +i));
    }


}

