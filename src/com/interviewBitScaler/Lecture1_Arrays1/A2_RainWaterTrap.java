package com.interviewBitScaler.Lecture1_Arrays1;

public class A2_RainWaterTrap {

    public static int trap(final int[] A) {
        if (A.length==0){
            return -1;
        }

        int maxHeight = Integer.MIN_VALUE;
        int maxIndex = 0;

        //find the height of maximum building
        for(int i=0;i<A.length;i++){
            if(A[i] > maxHeight){
                maxHeight= A[i];
                maxIndex = i;
            }
        }
        int waterHeight=0;
        int totalWaterTrapped =0 ;


        int leftmax = A[0];
        for(int  i= 0 ;i< maxIndex ;i++){
            leftmax = Math.max(leftmax,A[i]);
            if(leftmax>A[i]){
                waterHeight = Math.min(leftmax,maxHeight);
                totalWaterTrapped += waterHeight-A[i];
            }
        }

        int rightMax = A[A.length-1];
        for (int i = A.length-1; i >maxIndex; i--) {
            rightMax = Math.max(rightMax,A[i]);
            if(rightMax > A[i]){
                waterHeight = Math.min(rightMax,maxHeight);
                totalWaterTrapped += waterHeight-A[i];
            }
        }

        return totalWaterTrapped;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        System.out.println(trap(a));
    }
}
