package com.company.Leetcode.Feb;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_03_02_2020 {


    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(target==nums[i]+nums[j]){
                    return new int[]{i , j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumWithHashtable(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution found");
    }

    public int[] twoSumWithHashtableSingleIteration(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int compliment = target-nums[i];
            if(map.containsKey(compliment)){
                return new int[]{i , map.get(compliment)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution found");
    }



    public static void main(String[] args) {
        int nums [] = new int[] {5, 9 ,4,2};
        int target = 9;
        TwoSum_03_02_2020 obj = new TwoSum_03_02_2020();

        int[] result = obj.twoSum(nums ,target);
        System.out.println(result[0]+" "+result[1]);

        int[] resultWithHashtable = obj.twoSumWithHashtable(nums ,target);
        System.out.println(resultWithHashtable[0]+" "+resultWithHashtable[1]);

        int[] resultWithHashtableSingleIteration = obj.twoSumWithHashtableSingleIteration(nums ,target);
        System.out.println(resultWithHashtableSingleIteration[0]+" "+resultWithHashtableSingleIteration[1]);
    }
}
