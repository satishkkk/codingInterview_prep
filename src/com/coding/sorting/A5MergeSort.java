package com.coding.sorting;

//divide & concure

// WORST: O(nlog(n)) time | O(nlog(n)) space
import java.util.Arrays;

public class A5MergeSort {
    public static void main(String[] args) {
        int a[] = new int[]{5, 1, 6, 2, 3, 4, 8, 9, 7, 10};
        int[] out = mergeSort(a);
        Arrays.stream(out).forEach(System.out::println);
    }

    public static int[] mergeSort(int[] array) {
        //BASE CASE
        if (array.length <= 1) {
            return array;
        }
        int middleIndex = array.length / 2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, middleIndex);
        int[] rightHalf = Arrays.copyOfRange(array, middleIndex, array.length);

        //hypothesis -> left and right array will be sorted
        int[] sortedLeftHalf= mergeSort(leftHalf);
        int[] sortedRightHalf= mergeSort(rightHalf);

        //INDUCTION
        return mergerSortedArrays(sortedLeftHalf, sortedRightHalf);
    }

    public static int[] mergerSortedArrays(int[] leftHalf, int[] rightHalf) {
        int[] sortedArray = new int[leftHalf.length + rightHalf.length];
        int i = 0, j = 0, k = 0;
        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] < rightHalf[j]) {
                sortedArray[k++] = leftHalf[i++];
            } else {
                sortedArray[k++] = rightHalf[j++];
            }
        }
        while (i < leftHalf.length) {
            sortedArray[k++] = leftHalf[i++];
        }
        while (j < rightHalf.length) {
            sortedArray[k++] = rightHalf[j++];
        }
        return sortedArray;
    }
}
