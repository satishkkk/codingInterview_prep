package com.interviewBitScaler.Lecture2_Arrays2;

public class L581_ShortedUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] A = new int[]{1,3,2,3,3};
        System.out.println(findUnsortedSubarray(A));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int leftBoundryIndex= 0;
        int rightBoundryIndex=0;

        int n = nums.length;
        // [2,6,4,8,10,9,15]
        boolean isAscending = true;
        boolean isDecending = true;
        for(int i=0;i<n-1;i++){
            if(nums[i] > nums[i+1]){
                leftBoundryIndex = i;
                isAscending=false;
                break;
            }
        }

        if(isAscending) return 0;

        for(int i=n-1;i>0;i--){
            if(nums[i] < nums[i-1]){
                rightBoundryIndex = i;
                isDecending=false;
                break;
            }
        }

        if(isDecending) return n;

        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        for(int i=leftBoundryIndex;i<=rightBoundryIndex;i++){
            min = Math.min(nums[i],min);
            max = Math.max(nums[i],max);
        }
        //first largest element smaller then min

        int j = leftBoundryIndex;
        while(j>=0){
            if(min < nums[j]){
                j--;
            }else{
                break;
            }
        }
        j++;
        int k = rightBoundryIndex;
        while(k<n){
            if(max > nums[k]){
                k++;
            }else{
                break;
            }
        }
        // if(k<n)
        k--;
        return Math.abs(k-j+1);
    }
}
