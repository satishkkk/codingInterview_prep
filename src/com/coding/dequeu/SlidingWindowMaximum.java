package com.coding.dequeu;

import java.util.PriorityQueue;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
    public static void main(String[] args) {

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        int ans[] = new int[nums.length-k+1];
        int left = 0;
        for(int i=0;i<k;i++){
            maxHeap.add(nums[i]);
        }

        ans[left]=maxHeap.peek();
        for(int right=k;right<nums.length;right++){
            maxHeap.remove(nums[left++]);
            maxHeap.add(nums[right]);
            ans[left]=maxHeap.peek();
        }
        return ans;
    }


}
