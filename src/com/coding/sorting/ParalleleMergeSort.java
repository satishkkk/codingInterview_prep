package com.coding.sorting;

import java.util.Arrays;

public class ParalleleMergeSort {

    public static void main(String[] args) {
        int a[] = new int[]{4,5,6,3,2,3,4,5,7,8,9,9,876,543,5,678,9,8,765,4,56,78,7,654,3456,78,7,654,45,6789,98};
        Arrays.parallelSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

}
