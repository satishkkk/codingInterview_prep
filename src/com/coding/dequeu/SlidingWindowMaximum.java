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
        // assume nums is not null
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1]; // number of windows
        Deque<Integer> win = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; ++i) {
            // remove indices that are out of bound
            while (win.size() > 0 && win.peekFirst() <= i - k) {
                win.pollFirst();
            }
            // remove indices whose corresponding values are less than nums[i]
            while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }
            // add nums[i]
            win.offerLast(i);
            // add to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
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
