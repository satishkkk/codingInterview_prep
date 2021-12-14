package com.coding.recursion.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class A1_subsetInSortedOrder {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,3,2));
        ArrayList<ArrayList<Integer>> aa= subsets(A);
        System.out.println("jkds");
    }

    static ArrayList<ArrayList<Integer>> out = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        generateSubset(A.stream().mapToInt(Integer::intValue).toArray(),new int[n],0);
        
        return out;
    }

    public static void generateSubset(int[] nums,int[] curr,int index){

        if(index==nums.length){//Base Case
            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0;i<curr.length;i++){
                if(curr[i]==1)
                    list.add(nums[i]);
            }
            out.add(list);
            return;
        }

        curr[index] = 0;
        generateSubset(nums,curr,index+1);
        curr[index] = 1;
        generateSubset(nums,curr,index+1);
    }


}
