package com.interviewBitScaler;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A3_AllocateBook {
    public static void main(String[] args) {
        System.out.println();

        ArrayList<Integer> A = new ArrayList(Arrays.asList(73, 58, 30, 72, 44, 78, 23, 9 ));
        System.out.println(books(A,5));

    }

    public static int books(ArrayList<Integer> A, int B) {

        if(A.size() < B)
            return -1;

        int sum = 0;
        for(Integer i : A){
            sum+=i;
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        int result = 0;
        while(start < end){
            int mid = start+((end-start)>>1);
            if(isPossible(A,B,mid,sum)){
                result = mid;
                end = mid-1;

            }else{
                start = mid+1;
            }
        }
        return result;

    }

    public static boolean isPossible(ArrayList<Integer> A, int B, int distributionQty,int totalPages ){
        int count =0;
        int sum = 0 ;
        for(int i=0;i<A.size();i++){
            sum += A.get(i);
            if(sum >= distributionQty){
                count++;
                sum=0;
            }
            if(count >= B)
                return true;
        }
        return false;
    }

}
