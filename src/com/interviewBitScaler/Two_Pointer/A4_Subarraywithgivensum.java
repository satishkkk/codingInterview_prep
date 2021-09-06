package com.interviewBitScaler.Two_Pointer;

import java.lang.reflect.Array;
import java.util.*;

public class A4_Subarraywithgivensum {
    public static void main(String[] args) {

    }
    public static int[] solve(int[] A, int B) {


        int sum=0;
        for(int i=0;i<A.length;i++){
            sum=A[i];
            int ptr2 = i+1;
            while(sum < B && ptr2<A.length){
                sum += A[ptr2++];
            }
            if(sum==B){
                return Arrays.copyOfRange(A,i,ptr2);
            }
        }

        return new int[]{-1};
    }
}
