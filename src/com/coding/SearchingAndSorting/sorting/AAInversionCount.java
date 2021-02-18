package com.coding.SearchingAndSorting.sorting;

//APPLICATION OF MERGE SORT
import java.io.IOException;

// 1. divide array into 2 parts
// 2. merges sort left and right array plus caluclate inversion count in respective array
// 3. count = left inverasion count + right inversion count + count during merging

public class AAInversionCount {
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//
//        String[] s = br.readLine().split("\\s+");
//        for (int i = 0; i < s.length; i++) {
//            arr[i] = Integer.parseInt(s[i]);
//        }

        int arr[] = new int[]{2, 5, 1, 3, 4};
        long count = merge_sort(arr, 0, arr.length - 1);
        System.out.println(count);
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
            if (array[i] <= array[j]) {
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
