package com.coding.recursion.advance;

import java.util.*;

public class A1subsequenceOfString_DuplicateSubset_Recursion_Advance {

    static Set<List<Integer>> out = new HashSet<>();

    public static void main(String[] args) {
        List<List<Integer>> aa= subsetsWithDup(new int[]{1,2,2});
        aa.forEach(System.out::println);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        generateSubset(nums,nums.length);
        List<List<Integer>> a = new ArrayList<>(out);
        return a;
    }

    public static void generateSubset(int[] nums,int n){
        if(n==0){
            out.add(new ArrayList<>());
            return;
        }
        generateSubset(nums,n-1);

        Set<List<Integer>> outCopy = new HashSet<>(out);

        for(List<Integer> element: outCopy){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(element);

            temp.add(nums[n-1]);
            out.add(temp);
        }
    }

}
