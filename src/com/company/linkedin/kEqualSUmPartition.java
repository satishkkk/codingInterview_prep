package com.company.linkedin;

import java.util.Arrays;

public class kEqualSUmPartition {
    public static void main(String[] args) {

    }

    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            totalArraySum += arr[i];
        }
        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }
        // Sort in decreasing order.
//        Arrays.sort(arr);
//        reverse(arr);
        int targetSum = totalArraySum / k;
        boolean[] taken = new boolean[n];
        return backtrack(arr, 0, 0, 0, k, targetSum, taken);
    }

    //     TC - O(K * 2^N) | SC O(N)
    private boolean backtrack(int[] arr, int index, int count, int currSum, int k,
                              int targetSum, boolean[] taken) {

        int n = arr.length;

        if (count == k - 1) {
            return true;
        }

        // No need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        if (currSum == targetSum) {
            return backtrack(arr, 0, count + 1, 0, k, targetSum, taken);
        }

        for (int j = index; j < n; ++j) {
            if (!taken[j]) {
                // Include this element in current subset.
                taken[j] = true;
                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, taken)) {
                    return true;
                }
                // Backtrack step.
                taken[j] = false;
            }
        }
        return false;
    }

    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}


