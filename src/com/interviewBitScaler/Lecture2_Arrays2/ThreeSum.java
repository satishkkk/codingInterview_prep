package com.interviewBitScaler.Lecture2_Arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplet = new ArrayList<>();
        Arrays.sort(nums); // n log n
        int n = nums.length;
        if(n<2) return triplet;

        for(int i=0;i<n && nums[i]<=0;i++){
            if(i==0 || nums[i-1] != nums[i]){
                int startIndex = i+1;
                int endIndex = n-1;
                while(startIndex < endIndex){
                    int sum = nums[startIndex] + nums[endIndex] + nums[i];
                    if( sum == 0){
                        List<Integer> list= new ArrayList<>(Arrays.asList(nums[i],nums[startIndex],nums[endIndex]));
                        triplet.add(list);
                    }
                    if(sum <= 0){
                        int startElement= nums[startIndex++];
                        while(startIndex<n && nums[startIndex] == startElement) {
                            startIndex++;
                        }
                    }else{
                        int endElement= nums[endIndex--];
                        while(endIndex>0 && nums[endIndex] == endElement) endIndex--;
                    }
                }
            }


        }
        return triplet;
    }
}
