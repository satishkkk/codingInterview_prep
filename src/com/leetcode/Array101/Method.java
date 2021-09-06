package com.leetcode.Array101;

public class Method {
    public static void main(String[] args){
        int arr[] = new int[]{1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int n= nums.length;
        int l=0,r=0,ans =0;
        int zeroCount=0;
        boolean isContinue = true;
        while(r<n){
            if(nums[r]==1) r++;
            else if(nums[r]==0){
                zeroCount++;
                if(zeroCount<2){
                    r++;
                }else{
                    isContinue= false;
                    ans = Math.max(ans,r-l);
                    while(l<n && nums[l] != 0){
                        l++;
                    }
                    l++;
                    zeroCount++;
                    r++;
                }
            }
        }
        return isContinue ? r-l+1 : ans;

    }
}
