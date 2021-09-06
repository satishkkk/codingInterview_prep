package com.interviewBitScaler.Two_Pointer;

import java.util.*;

public class P1_CountPairswhoseSumIsB {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};
        int B=1;
        int count = solve(A,B);
        System.out.println(count);
    }

    public static int solve(int[] A, int B) {
        int mod = 1000*1000*1000+7;

        int ptr1=0 , ptr2=A.length-1;
        long result=0;
        while( ptr1 < ptr2 ){
            int sum = A[ptr1]+A[ptr2];
            if(sum==B){
                if(A[ptr1] == A[ptr2]){
                    //same element's sum is B
                    long count=ptr2-ptr1+1;
                    result += ((1l*count*(count-1))/2)%mod; // nC2
                    result %= mod;
                    break;
                }else{
                    //two differemnt element's sum is B
                    int nextUniqueIndex1=ptr1,nextUniqueIndex2=ptr2;

                    while( A[nextUniqueIndex1]==A[ptr1]){
                        nextUniqueIndex1++;
                    }
                    long count1 = nextUniqueIndex1-ptr1;
                    ptr1=nextUniqueIndex1;

                    while(A[nextUniqueIndex2]==A[ptr2]){
                        nextUniqueIndex2--;
                    }
                    long count2 = ptr2-nextUniqueIndex2;
                    ptr2=nextUniqueIndex2;

                    result += (1l*count1*count2)%mod;
                    result = result %mod;
                }
            }else if(sum > B){
                ptr2--;
            }else{
                ptr1++;
            }
        }
        return (int)result;
    }


}
