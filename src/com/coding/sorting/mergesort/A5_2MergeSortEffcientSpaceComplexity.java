package com.coding.sorting.mergesort;

import java.util.Arrays;

// TIME O(N(Log N)) | SPACE O(1) // LIMITATION : :work only in integer . . .

/*First we have to find a value greater than all the elements of the array. Now we can store the original value as modulus and the second value as division.
 Suppose we want to store arr[i] and arr[j] both at index i(means in arr[i]).
 First we have to find a ‘maxval’ greater than both arr[i] and arr[j].

  Now we can store as
  arr[i] = arr[i] + arr[j]*maxval.
  Now
  arr[i]%maxval will give the original value of arr[i] and
  arr[i]/maxval will give the value of arr[j].*/
public class A5_2MergeSortEffcientSpaceComplexity {

    public static void main(String[] args) {
        int arr[] = new int[]{8,7,6,5};
        mergeSort(arr,arr.length);
        Arrays.stream(arr).forEach(System.out::println);
    }

    // This functions finds
    // max element and calls
    // recursive merge sort.
    static void mergeSort(int[] arr, int n)
    {
        int maxele = Arrays.stream(arr).max().getAsInt() + 1;
        mergeSortRec(arr, 0, n - 1, maxele);
    }

    // Recursive merge sort
    // with extra parameter, naxele
    static void mergeSortRec(int[] arr, int beg, int end, int maxele)
    {
        if (beg < end)
        {
            int mid = (beg + end) / 2;

            mergeSortRec(arr, beg, mid, maxele);
            mergeSortRec(arr, mid + 1, end, maxele);
            merge(arr, beg, mid, end, maxele);
        }
    }


    static void merge(int[] arr, int beg, int mid, int end, int maxele)
    {
        int i = beg;
        int j = mid + 1;

        int k = beg;

        while (i <= mid && j <= end)
        {
            //maxele is max of all element
            if (arr[i] % maxele <= arr[j] % maxele)
            {
                arr[k] = arr[k] + (arr[i] % maxele) * maxele;
                k++;
                i++;
            }
            else
            {
                arr[k] = arr[k] + (arr[j] % maxele) * maxele;
                k++;
                j++;
            }
        }

        while (i <= mid)
        {
            arr[k] = arr[k] + (arr[i] % maxele) * maxele;
            k++;
            i++;
        }
        while (j <= end)
        {
            arr[k] = arr[k] + (arr[j] % maxele) * maxele;
            k++;
            j++;
        }

        // Obtaining actual values
        for (i = beg; i <= end; i++)
        {
            arr[i] = arr[i] / maxele;
        }
    }
}
