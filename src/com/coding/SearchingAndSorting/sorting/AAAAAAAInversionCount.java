package com.coding.SearchingAndSorting.sorting;

//APPLICATION OF MERGE SORT
public class AAAAAAAInversionCount {

    // 1. divide array into 2 parts
    // 2. merges ort left and right array plus caluclate inversion count in respective array
    // 3. count = left inverasion count + right inversion count + count during merging
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//
//        String[] s = br.readLine().split("\\s+");
//        for (int i = 0; i < s.length; i++) {
//            arr[i] = Integer.parseInt(s[i]);
//        }
//
//        //int arr[] = new int[]{2,5,1,3,4}; //ans = 4 pair
//        long count = mergeSortAndCount(arr,0,arr.length-1);
//        System.out.println(count);
//    }
//
//    public static long mergeSortAndCount(int[] array,int leftIdx,int rightIdx) {
//        // Keeps track of the inversion count at a
//        // particular node of the recursion tree
//        long count = 0;
//
//        if (leftIdx < rightIdx) {
//            int middleIdx = (leftIdx + rightIdx) / 2;
//
//            // Total inversion count = left subarray count
//            // + right subarray count + merge count
//
//            // Left subarray count
//            count += mergeSortAndCount(array, leftIdx, middleIdx);
//
//            // Right subarray count
//            count += mergeSortAndCount(array, middleIdx + 1, rightIdx);
//
//            // Merge count
//            count += mergeAndCount(array, leftIdx, middleIdx, rightIdx);
//        }
//        return count;
//    }
//
//    // Function to count the number of inversions
//    // during the merge process
//    private static long mergeAndCount(int[] arr, int leftIdx, int middleIdx, int rightIdx)
//    {
//        // Left subarray
//        int[] left = Arrays.copyOfRange(arr, leftIdx, middleIdx + 1);
//        // Right subarray
//        int[] right = Arrays.copyOfRange(arr, middleIdx + 1, rightIdx + 1);
//
//        int i = 0, j = 0, k = leftIdx;
//        long swaps = 0;
//
//        while (i < left.length && j < right.length)
//        {
//            if (left[i] <= right[j])
//                arr[k++] = left[i++];
//            else {
//                arr[k++] = right[j++];
//                swaps += (middleIdx + 1) - (leftIdx + i);
//            }
//        }
//        return swaps;
//    }



}
