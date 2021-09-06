package com.interviewBitScaler.Two_Pointer;

import java.util.Arrays;

public class P3_3sum {
    public static void main(String[] args) {
      int[] A= new int[]{5, -2, -1, -10, 10 };
      int B = 5;
        System.out.println(threeSumClosest(A,B));
    }

    public static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);

        int sum=0;
        int ans = Integer.MAX_VALUE;
        int result=0;

        for(int i=0;i<A.length-1;i++){

            int ptr1 = i+1;
            int ptr2 = A.length-1;

            while(ptr1<ptr2){
                sum = A[i]+A[ptr1]+A[ptr2];

                if(ans > Math.abs(sum-B)){
                    ans =Math.abs(sum-B);
                    result = sum;
                }

                if( B > sum ){
                    ptr1++;
                }else{
                    ptr2--;
                }

            }
        }
        return result;
    }
}
