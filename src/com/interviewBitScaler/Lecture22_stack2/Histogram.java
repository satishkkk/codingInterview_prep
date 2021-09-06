package com.interviewBitScaler.Lecture22_stack2;

import java.util.Stack;

public class Histogram {
    public static void main(String[] args) {
        int[] a = new int[]{1,1};
        System.out.println(largestRectangleArea(a));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] smallestLeft= new int[n];
        int[] smallestRight= new int[n];

        Stack<Integer> stack = new Stack<Integer>();
        //smallest left
        for(int i=0;i<n;i++){
            while( !stack.isEmpty() &&  heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                smallestLeft[i] = -1;
            }else{
                smallestLeft[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        //Smallest right
        for(int i=n-1;i>=0;i--){
            while( !stack.isEmpty() &&  heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                smallestRight[i] = n;
            }else{
                smallestRight[i] = stack.peek();
            }
            stack.push(i);
        }

        int max = 0;
        for(int i=0;i<n;i++){
            int weidth = smallestRight[i]-smallestLeft[i]-1;
            max= Math.max(max,heights[i]*weidth);
        }
        return max;
    }

}
