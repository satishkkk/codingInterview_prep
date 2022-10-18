package com.coding.recursion.Lecture7_Recursion.RecursionGet;

import java.util.ArrayList;
import java.util.List;

public class printcombinationOfSizeN {

    static private int[] A = new int[]{5,6,7,8};
    static private int N = 3;
    static List<List<Integer>> out = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        printCombination(A,N,0,arr);
    }

    public static void printCombination(int[] A, int size , int i,ArrayList<Integer> arr){

        if(arr.size()==size){
            System.out.println(arr);
            return;
        }

        if(i>=A.length){
            return ;
        }
        //consider current element
        arr.add(A[i]);
        printCombination(A,size,i+1,arr);

        arr.remove(arr.size()-1);
        //do not consider current element
        printCombination(A,size,i+1,arr);
    }
}
