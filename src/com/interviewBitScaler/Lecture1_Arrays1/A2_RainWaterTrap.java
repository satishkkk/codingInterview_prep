package com.interviewBitScaler.Lecture1_Arrays1;

public class A2_RainWaterTrap {
    //  TC - O(N) | SC - O(1)
    public static int trap2(int[] height) {
        int n = height.length,ans = 0;
        int maxLeftHeight = 0, maxRightHeight = 0;
        int left =0,right = n-1;

        while(left < right){
            if(height[left] < height[right]){
                 if(maxLeftHeight <= height[left])
                     maxLeftHeight = height[left];
                 else
                     ans+= maxLeftHeight-height[left];
                left++;
            }else{
                 if(maxRightHeight <= height[right])
                     maxRightHeight = height[right];
                 else
                     ans+= maxRightHeight-height[right];
                right--;
            }
        }
        return ans;
    }

//      TC - O(N) (2 iteration)| SC - O(N)
      public static int trap1(int[] height) {
             int  n = height.length;
             if(n==0) return 0;
             int[] lm = new int[n];
             int[] rm = new int[n];

             lm[0] = height[0];
             for(int i=1;i<n;i++){
                 lm[i] = Math.max(height[i],lm[i-1]);
             }

             rm[n-1] = height[n-1];
             for(int i=n-2;i>=0;i--){
                 rm[i] = Math.max(height[i],rm[i+1]);
             }

             int ans =0;
             for(int i=0;i<n;i++){
                 ans+=( Math.abs( height[i] - Math.min(lm[i],rm[i]) ) );
             }

                 return ans;
     }
//      TC - O(N^2) (2 iteration)| SC - O(N)
    public static int trap0(final int[] A) {
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
        System.out.println(trap2(a));
    }
}
