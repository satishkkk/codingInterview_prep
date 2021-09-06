package com.coding.sorting.application;

public class ReversePairMergeSort {
    public static void main(String[] args) {
        int[] A = new int[] {1, 3, 2, 3, 1};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        return (int)merge_sort(A,0,A.length-1);
    }

    private static long merge_sort(int[] array, int leftIdx, int rightIdx) {
        long count = 0;
        if (leftIdx < rightIdx) { //base condition
            int midIdx = (leftIdx + rightIdx) / 2;

            //Hypothesis
            count += merge_sort(array, leftIdx, midIdx);
            count += merge_sort(array, midIdx + 1, rightIdx);

            //Induction
            count += merge(array, leftIdx, midIdx + 1, rightIdx);
        }
        return count;
    }

    private static long merge(int[] array, int leftIdx, int midIdx, int rightIdx) {
        int i = leftIdx;
        int j = midIdx;
        int k = 0;
        long count = 0;

        int temp[] = new int[(rightIdx - leftIdx + 1)];

        while (i < midIdx && j <= rightIdx) {
            if (array[i] <= 2*array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                count += (long) (midIdx - i);
            }
        }

        while (i < midIdx) {
            temp[k++] = array[i++];
        }

        while (j <= rightIdx) {
            temp[k++] = array[j++];
        }

        for (i = leftIdx, k = 0; i <= rightIdx; i++, k++) {
            array[i] = temp[k];
        }
        return count;
    }

}
