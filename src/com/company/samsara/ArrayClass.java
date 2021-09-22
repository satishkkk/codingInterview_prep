package com.company.samsara;

public class ArrayClass {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{2,1,-1}));
    }

    public static int pivotIndex(int[] nums) {
//       [2,1,-1]
//       0  1  2
        int left =0;
        int right = nums.length-1;//5
        int leftSum = 0;//1
        int rightSum = 0;//6

        while(left <= right){
            if(leftSum < rightSum){
                leftSum += nums[left++];//8
            }else{
                rightSum += nums[right--];//11
            }
            if(leftSum == rightSum ) return left;
        }
        //1 3 5 2 2
        return -1;
    }
}
