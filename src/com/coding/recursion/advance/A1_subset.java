package com.coding.recursion.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A1_subset {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
//        System.out.println(subsets_backtracking(nums));
    }

    //Way 1 : SCALER WAYS
    static List<List<Integer>> subSets = new ArrayList<>();

    //[1,2,3]
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int[] tempNumber = new int[n];
        Arrays.sort(nums);
        generate(tempNumber,0,nums);
        return subSets;
    }

    public static void generate(int[] tempNumber ,int index ,int[] nums){
        if(index == tempNumber.length){
//            System.out.println("TempNumber");
//            Arrays.stream(tempNumber).forEach(System.out::println);
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<tempNumber.length;i++){
                if(tempNumber[i] == 1){
                    list.add(nums[i]);
                }
            }
            subSets.add(list);
            return;
        }

        tempNumber[index] = 0;
        generate(tempNumber,index+1,nums);

        tempNumber[index] = 1;
        generate(tempNumber,index+1,nums);
    }

 // WAY2 :BACKTRACKING WAY

    public static List<List<Integer>> subsets_backtracking(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
