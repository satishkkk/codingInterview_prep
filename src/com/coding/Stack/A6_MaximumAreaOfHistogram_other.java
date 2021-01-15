package com.coding.Stack;

import java.util.Arrays;

public class A6_MaximumAreaOfHistogram_other {

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;
            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        System.out.println("Less from left " +Arrays.toString(lessFromLeft));


        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        System.out.println("Less from right " +Arrays.toString(lessFromRight));

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }


    public static void main(String[] args) {
        int[] in = new int[]{2,1,5,6,2,3};
        Integer[] out = new Integer[in.length];

        A6_MaximumAreaOfHistogram_other NS = new A6_MaximumAreaOfHistogram_other();

        System.out.println( NS.largestRectangleArea(in));
//        for(int i=0;i<out.length;i++)
//            System.out.println(out[i]);
//        Arrays.asList(out).forEach(n -> System.out.println(n));
    }
}
