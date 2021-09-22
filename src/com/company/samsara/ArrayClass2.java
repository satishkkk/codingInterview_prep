package com.company.samsara;

public class ArrayClass2 {

    public static void main(String[] args) {
        int ans = dominantIndex(new int[]{1,2,3,4});
        System.out.println(ans);
    }

    public static int dominantIndex(int[] nums) {

        int largestElement =0;
        int secondLargetElemet=0;
        int idxlargestElement =0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]> secondLargetElemet){
                if(nums[i] > largestElement){
                    secondLargetElemet = largestElement;
                    largestElement = nums[i];
                    idxlargestElement = i;
                }else{
                    secondLargetElemet = nums[i];
                }
            }
        }
        return secondLargetElemet*2 <= largestElement ? idxlargestElement : -1;

    }
}
