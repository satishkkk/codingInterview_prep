package com.interviewBitScaler.Lecture13_Sorting;

import java.util.Arrays;

public class MaximumUnsortedSubarray {

    public static void main(String[] args) {
        int[] A = new int[]{4, 15, 4, 4, 15, 18, 20};
        int[] out = subUnsort(A);
        Arrays.stream(out).forEach(System.out::println);
    }

    public static int[] subUnsort(int[] A) {
        int n = A.length;
        if (n==1) return new int[]{-1};

        int start =0;
        int end = n-1;

        //find start of unsorted array
        for(int i=1;i<n;i++){
            if(A[i]<A[i-1]){
                start = i;
                break;
            }
        }

        if(start ==0 ) return new int[]{-1}; //already sorted

        //find end of unsorted array
        for(int i = n-1;i>0;i--){
            if(A[i] < A[i-1]){
                end = i;
                break;
            }
        }

        int min = A[start];
        int max = A[end];
        for(int i=start;i<=end;i++){
            min = Math.min(min,A[i]);
            max = Math.max(max,A[i]);
        }

        for(int i=0;i<start;i++){
            if(A[i] > min){
                start = i;
                break;
            }
        }

        for(int i=n-1;i>end;i--){
            if(A[i]<max){
                end=i;
                break;
            }
        }

        return new int[]{start,end};
    }
}
