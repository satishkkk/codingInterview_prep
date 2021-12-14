package com.coding.recursion.DivideAndConqure;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int [] lst) {
        /* Sorts an array in the ascending order in O(n log n) time */
        int n = lst.length;
        qSort(lst, 0, n - 1);
    }

    private static void qSort(int [] lst, int lo, int hi) {
        if (lo < hi) {
            int p = partition(lst, lo, hi);
            qSort(lst, lo, p - 1);
            qSort(lst, p + 1, hi);
        }
    }

    private static int partition(int [] lst, int lo, int hi) {
    /*
      Picks the last element hi as a pivot
      and returns the index of pivot value in the sorted array */
        int pivot = lst[hi];
        int i = lo;
        for (int j = lo; j < hi; ++j) {
            if (lst[j] < pivot) {
                swap(lst,i,j);
                i++;
            }
        }
        swap(lst,i,hi);
        return i;
    }

    public static void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{9,7,5,1};
        quickSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
