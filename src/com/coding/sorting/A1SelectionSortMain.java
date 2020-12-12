package com.coding.sorting;

import java.util.Arrays;
// O(n^2) time | O(1) Space

/* in each iteration smallest element is reaching to its right position (i.e Ascending order hai to 1 st position)
 *
 * so in first round smallest element will reach at the first index
 * in 2 nd round , 2 nd smallest element will reach at second index*/
public class A1SelectionSortMain {

    public static int[] SelectionSort(int[] array) {

        for(int startIndex=0 ; startIndex< array.length-1; startIndex++){
            //Find min element in array
            int smallestidx = startIndex;
            for(int i = startIndex+1 ; i < array.length; i++){
                if(array[smallestidx] > array[i]){
                    smallestidx=i;
                }
            }
            swap(startIndex,smallestidx,array);
        }
        return array;
    }


    public static int[] SelectionSort1(int[] array) {
        if(array.length ==0)
            return new int[] {};
        int startIndex = 0 ;
        while(startIndex <array.length-1){
            int smallestidx = startIndex;
            for(int i = startIndex+1 ; i < array.length; i++){
                if(array[smallestidx] > array[i]){
                    smallestidx=i;
                }
            }
            swap(startIndex,smallestidx,array);
            startIndex++;
        }
        return array;
    }




    public static void swap(int i,int j,int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8,5,2,9,5,6,3};
        int[] sortedarray = SelectionSort1(arr);
        Arrays.stream(sortedarray).forEach(i -> System.out.println( " " +i));
    }


}
