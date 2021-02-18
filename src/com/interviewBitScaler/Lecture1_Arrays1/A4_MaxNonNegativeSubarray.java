package com.interviewBitScaler.Lecture1_Arrays1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A4_MaxNonNegativeSubarray {
    public static void main(String[] args) {
        int A[] = new int[]{ 0, 0, -1, 0 };
        int[] out = maxset(A);
        Arrays.stream(out).forEach(System.out::println);
    }


    public static int[] maxset(int[] A) {
        int maxSum = 0;
        int newSum =0 ;

        List<Integer> maxArray = new ArrayList<>();
        List<Integer> newArray = new ArrayList<>();

        for(int element : A){
            if(element<0){
                newSum=0;
                newArray = new ArrayList<>();
            }else{
                newSum += element;
                newArray.add(element);
            }

            if( (newSum>maxSum) || ((newSum==maxSum) && (newArray.size() > maxArray.size())) ){
                maxSum =newSum;
                maxArray = newArray;
            }
        }


        int[] arr = new int[maxArray.size()];
        int j=0;
        for(int i : maxArray){
            arr[j++] = i;
        }

        return arr;
    }

}
