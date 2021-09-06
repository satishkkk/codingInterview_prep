package com.interviewBitScaler.Lecture1_Arrays1;

import java.lang.reflect.Array;
import java.util.*;

public class A0_RemoveDuplicatesFromSortedArrays {

    public static void main(String[] args) {
//        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5,5};
//        int n = arr.length;
//
//        int[] out = removeDuplicates(arr, n);
//        Arrays.stream(out).forEach(System.out::println);

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,3,3,5,5,8,10));
        ArrayList<Integer> uniqueArray =  removeDuplicate(A);
        System.out.println("hi");
        uniqueArray.stream().forEach(System.out::println);

    }

    public static int[] removeDuplicates(int A[], int n){

        int j=0;

        for (int i = 0; i <n-1 ; i++) {

            if(A[i] != A[i+1]){
                A[j]=A[i];
                j++;
            }

        }

        A[j]=A[n-1];
        j++;
        return Arrays.copyOfRange(A,0,j);
    }

    public static ArrayList<Integer> removeDuplicate(ArrayList<Integer> A){
        int j =0 ;
        for(int i=0; i<A.size()-1;i++){
            if(A.get(i) != A.get(i+1)){
                A.set(j,A.get(i));
                j++;
            }
        }
        A.set(j,A.get(A.size()-1));
        j++;
        return  new ArrayList<Integer>(A.subList(0,j));
    }


}
