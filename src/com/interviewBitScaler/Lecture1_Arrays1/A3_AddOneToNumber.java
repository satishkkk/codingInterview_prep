package com.interviewBitScaler.Lecture1_Arrays1;

import java.util.Arrays;

public class A3_AddOneToNumber {

    public static void main(String[] args) {
        int[] a= new int[]{0,0,9,8,9};
        int[] out = plusOne(a);
        Arrays.stream(out).forEach(System.out::println);
    }

    public static int[] plusOne(int[] A) {
        int startIdx =0 ;
        for(int i=0;i<A.length;i++){
            if(A[i]!=0){
                startIdx=i;
                break;
            }
        }

        A[A.length-1] = A[A.length-1]+1;
        int carry =0;

        if(A[A.length-1] > 9)
            carry=1;

        for(int i=A.length-1 ; i>=startIdx;i--){
            if(A[i]>=9 && carry == 1){
                A[i]=0;
                carry=1;
            }else if(A[i]<9 && carry == 1){
                A[i] = A[i]+1;
                carry=0;
            }
        }

        if(carry==1){
            int[] out = new int[A.length+1-startIdx];
            out[0]=1;
            System.arraycopy(A,startIdx,out,1,A.length-startIdx);

            return out;
        }else{
            int[] out = new int[A.length-startIdx];
            System.arraycopy(A,startIdx,out,0,A.length-startIdx);
            return out;
        }

    }
}
