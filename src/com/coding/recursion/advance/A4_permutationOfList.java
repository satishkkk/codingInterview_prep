package com.coding.recursion.advance;

import java.util.ArrayList;
import java.util.List;

public class A4_permutationOfList {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        permute(new int[]{1,2,3});
//        list.forEach(System.out::println);
    }


    public static int[][] permute(int[] A) {
        permuteHelper(A,new int[A.length],0);
        list.forEach(System.out::println);
        return null;
//        return list.toArray(new int[list.size()][]);
    }

    public static void permuteHelper(int[] A , int[] curr, int index){
        if(index == A.length){
            List<Integer> tmplist = new ArrayList<>();
            for(int i : curr){
                tmplist.add(i);
            }
            list.add(tmplist);
            return;
        }

        for(int i=index;i<A.length;i++){//1,2,3
            curr[index] = A[i];
            permuteHelper(A,curr,index+1);
        }
    }
}
