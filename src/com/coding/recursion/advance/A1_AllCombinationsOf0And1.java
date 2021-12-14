package com.coding.recursion.advance;

import com.company.fb.GenerateParanthesisofSize_2N;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/subsets/
public class A1_AllCombinationsOf0And1 {

    static List<List<Integer>> out = new ArrayList<>();
    public static void main(String[] args) {
        int n=2;
        int[] curr = new int[n];
        generate(curr,0,n);
//        char[] curr1 = new char[2*n];
//        TODO : Application of this approch is generate paranthesis
//        GenerateParanthesisofSize_2N.generateParanthesis(curr1,0,4);
        int[] nums = new int[] {1,2,3,4};
        generateSubset(nums,new int[nums.length],0);
    }

    public static void generateSubset(int[] nums,int[] curr,int index){
        if(index==nums.length){//Base Case
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<curr.length;i++){
                if(curr[i]==1)
                    list.add(nums[i]);
            }
            out.add(list);
            return;
        }

        curr[index] = 0;// dont consider this number
        generateSubset(nums,curr,index+1);
        curr[index] = 1;// consider this number
        generateSubset(nums,curr,index+1);
    }

    static void generate(int[] curr,int i, int n){

        if(i==n){
            System.out.println("-----");
            Arrays.stream(curr).forEach(System.out::println);
            return;
        }

        curr[i]=1;
        generate(curr,i+1,n);
        curr[i]=2;
        generate(curr,i+1,n);
    }

}

