package com.coding.dequeu;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
    public static void main(String[] args) {
//        int nums[] = new int[]{1,3,-1,-3,5,3,6,7};
        int nums[] = new int[]{4,3,11};
        int k=3;
//        maxSlidingWindow(nums,k);//O(N*K)
        int ans[] = maxSlidingWindowOptimize(nums,k);
        Arrays.stream(ans).forEach(System.out :: println);

    }

    public static int[] maxSlidingWindowOptimize(int[] nums, int k){
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int i=0;
        //set first k elemet
        for(i=0;i<k;i++){
            if(!deque.isEmpty() && nums[deque.getFirst()] < nums[i]){
                deque.poll();
            }
            deque.add(i);
        }

        for(;i<n;i++){
            ans[i-k]=nums[deque.peek()];
            //1. Remove the element which are not the part of windows
            while(!deque.isEmpty() && deque.peek()<= i-k){
                deque.poll();
            }
            //2. Remvoe the elements which are not useful and are in windows
            while(!deque.isEmpty() && nums[i] >= nums[deque.getLast()]){
                deque.pollLast();
            }
            //3. add new element expansion
            deque.addLast(i);
        }
        ans[i-k]=nums[deque.peek()];
        return ans;

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
