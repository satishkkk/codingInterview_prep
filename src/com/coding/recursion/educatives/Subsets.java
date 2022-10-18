package com.coding.recursion.educatives;

import java.util.*;

class Subsets {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // TODO: Write your code here
        generate(nums,new ArrayList<Integer>(),subsets,0);
        return subsets;
    }

    public static void generate(int[] nums,List<Integer> current , List<List<Integer>> subsets, int i){
//        System.out.println("CURRENT");
//        System.out.println(current);
        List<Integer> list = new ArrayList<>(current);
        subsets.add(list);

        if(i >= nums.length) return;

        current.add(nums[i]);
        generate(nums,current,subsets,i+1);
        current.remove(current.size()-1);
        generate(nums,current,subsets,i+1);

    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

//        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
//        System.out.println("Here is the list of subsets: " + result);
    }
}
