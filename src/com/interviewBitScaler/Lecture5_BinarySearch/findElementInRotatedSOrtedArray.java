package com.interviewBitScaler.Lecture5_BinarySearch;

public class findElementInRotatedSOrtedArray {

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 1, 2, 3};
        int b = 4;
        System.out.println(search(a, b));
    }

    public static int search(final int[] A, int B) {

        //find the minimum element in rotated sorted array
        int start = 0, minIndex = -1, mid;
        int n = A.length;
        int end = n - 1;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (A[mid] <= A[n - 1]) {
                minIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // check in which part our elements lies
        end = n - 1;
        start = 0;
        if (B > A[end]) {
            end = minIndex - 1;
        } else {
            start = minIndex;
        }

        //apply binary search
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (A[mid] == B) return mid;
            if (A[mid] < B) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int search1(final int[] A, int B) {
        int n = A.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == B) return mid;
            else if (A[0] <= A[mid]) {//left part is sorted
                if (A[0] <= B && B < A[mid]) {
                    //B lies on left part
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {//right part is sorted
                if (A[mid] < B && B <= A[n - 1]) {
                    low = mid + 1;//B lies on right part
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}