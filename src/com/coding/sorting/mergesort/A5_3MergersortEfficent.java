package com.coding.sorting.mergesort;

import java.util.Arrays;

// TIME O(n log(n)) | SPACE O(n)
public class A5_3MergersortEfficent {

    public static void main(String[] args) {
        int a[] = new int[]{5, 1, 6, 2, 3, 4, 8, 9, 7, 10};
        mergeSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int[] auxiliaryArray = array.clone();
        mergeSort(array, 0, array.length - 1, auxiliaryArray);
        return array;
    }

    public static void mergeSort(int[] mainArray, int startIdx, int endIdx, int[] auxiliaryArray) {
        //BASE CASE
        if (startIdx == endIdx) {
            return;
        }
        int middleIdx = (startIdx + endIdx) / 2;
        //hypothesis -> left and right array must be sorted
        mergeSort(auxiliaryArray, startIdx, middleIdx, mainArray);
        mergeSort(auxiliaryArray, middleIdx + 1, endIdx, mainArray);
        //Inductions
        doMerge(mainArray, startIdx, middleIdx, endIdx, auxiliaryArray);

    }

    public static void doMerge(int[] mainArray, int startIdx, int middleIdx, int endIdx, int[] auxiliaryArray) {
        int k = startIdx;
        int i = startIdx;
        int j = middleIdx + 1;

        while (i <= middleIdx && j <= endIdx) {
            if (auxiliaryArray[i] <= auxiliaryArray[j]) {
                mainArray[k++] = auxiliaryArray[i++];
            } else {
                mainArray[k++] = auxiliaryArray[j++];
            }
        }

        while (i <= middleIdx) {
            mainArray[k++] = auxiliaryArray[i++];
        }

        while (j <= endIdx) {
            mainArray[k++] = auxiliaryArray[j++];
        }
    }
}
