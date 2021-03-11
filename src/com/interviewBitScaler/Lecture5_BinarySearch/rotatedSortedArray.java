package com.interviewBitScaler.Lecture5_BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rotatedSortedArray {
    public static void main(String[] args) {
//        int a[] = new int[]{4,5,6,7,0,1,2};
        int a[] = new int[]{5 ,1 ,2 ,3 ,4};
        System.out.println(rotatedBinarySearch1(a));
//        List<Integer> l= new ArrayList<>(Arrays.asList(5 ,1 ,2 ,3 ,4));
//        System.out.println(getMinElementIndex(l));
    }

    private static int findRotatedArray(int[] a) {
        int n = a.length;
        int start = 0;
        int end = n-1;

        while(start<end){
            int mid = start+(end-start)/2;

            if( a[mid] > a[end]){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }

    private static int rotatedBinarySearch1(int[] a) {
        int n = a.length;
        int start = 0;
        int end = n-1;

        while(start<end){

            int mid = start+(end-start)/2;
            int prev = (mid+n-1)%n;
            int next = ((mid+1)%n);

            if(a[mid] < a[prev] && a[mid] < a[next]) return mid;

            if( a[start] < a[mid] && a[end] <a[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    public static int getMinElementIndex(final List<Integer> A) {
        int first, last, start, end;
        int count, num, n;
        int mid;
        int next, prev;

        n = A.size();
        count = n;
        first = A.get(0);
        last = A.get(n - 1);
        start = 0;
        end = n - 1;

        while (count > 0) {

            mid = start + (end - start) / 2;

            num = A.get(mid);
            next = A.get((mid + 1) % n);
            prev = A.get((mid - 1 + n) % n);

            if (num < prev && num < next) {
                return mid;
            }

            if (num > first && num > last)
                start = mid + 1;
            else
                end = mid - 1;

            count /= 2;
        }

        return -1;

    }

}
