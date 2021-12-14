package com.coding.recursion.advance;

import java.util.*;

public class A1subsequenceOfString_DuplicateSubset_Recursion_Advance {

    public static void main(String[] args) {
        List<List<Integer>> out= subsetsWithDup(new int[]{0});
        out.forEach(System.out::println);
    }

    static Map<Integer,Integer> map = new HashMap<>();
    static List<List<Integer>> out = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        //create frequency map
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        //create unique number map
        int[] uniqueNumber = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(uniqueNumber);

        subsetsWithDupHelper(uniqueNumber,new int[uniqueNumber.length],0);
        return out;
    }

    static void subsetsWithDupHelper(int[] uniqueNumber, int[] curr, int index){

        if(index == uniqueNumber.length){ // base case
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<uniqueNumber.length;i++){
                    for(int j=0;j<curr[i];j++){
                        temp.add(uniqueNumber[i]);
                    }
            }
            out.add(temp);
            return;
        }

        int freq = map.get(uniqueNumber[index]);

        for(int value = 0; value<=freq;value++){
            curr[index]= value;
            subsetsWithDupHelper(uniqueNumber,curr,index+1);
        }
    }

//    public static List<List<Integer>> subsetsWithDup1(int[] nums) {
//        Arrays.sort(nums);
//        generateSubset1(nums,nums.length);
//        List<List<Integer>> a = new ArrayList<>(out);
//        return a;
//    }
//
//    public static void generateSubset1(int[] nums,int n){
//        if(n==0){
//            out.add(new ArrayList<>());
//            return;
//        }
//        generateSubset1(nums,n-1);
//
//        Set<List<Integer>> outCopy = new HashSet<>(out);
//
//        for(List<Integer> element: outCopy){
//            List<Integer> temp = new ArrayList<>();
//            temp.addAll(element);
//
//            temp.add(nums[n-1]);
//            out.add(temp);
//        }
//    }

}
