package com.coding.sorting;

import java.util.Arrays;

// O(n^2) time | O(1) Space

/* in each iteration largest element is reaching to its right position (i.e Ascending order hai to last position)
 *
 * so in first round largest element will reach at the end
 * in 2 nd round , 2 nd largest element will reach at second largest place*/
public class A2BubbleSortMain {

    public static int[] BubbleSort(int[] array) {
        if(array.length==0){
            return new int[]{};
        }
        boolean isSorted = false;
        int counter = 0;

        while(!isSorted){
            isSorted=true;
            for(int i=0; i<array.length-1-counter ;i++){
                if(array[i] > array[i+1]){
                    swap(i,i+1,array);
                    isSorted=false;
                }
            }
            counter++;
        }
        return array;
    }

    public static int[] BubbleSort1(int[] array) {
        for(int i = 0 ; i < array.length-1 ; i++){ // why n-1 ?
            for(int j = 0 ; j < array.length-1-i; j++ ){ //why n-1-j ? because last j th element is already sorted
                if(array[j] > array[j+1]){
                    swap(j,j+1,array);
                }
            }
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
        int[] sortedarray = BubbleSort(arr);
        Arrays.stream(sortedarray).forEach( i -> System.out.println( " " +i));
    }

}
