package com.interviewBitScaler.Lecture6_BinarySearchApplication;

import java.util.Arrays;

public class AggressiveCow {

    public static void main(String[] args) {
        int[] A= new int[]{5,11,17,100};
        int B = 2;
        System.out.println(solve(A,B));
    }
    public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length-1;
        int start = 1;
        int end = (A[n]-A[0]);
        int ans = 0;

        while(start<=end){
            int mid = (start+end)/2;
            if(isPossible(mid,A,B)){
                // System.out.println("Possible:"+mid);
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int k,int[] A,int totalCow){
        int prevIdx =0;
        int currentIdx=1;
        totalCow--;

        while(currentIdx<A.length && totalCow>0){
            if(A[currentIdx]-A[prevIdx] >= k){
                prevIdx = currentIdx;
                totalCow--;
            }
            currentIdx++;
        }

        if (totalCow==0) return true;
        else return false;
    }
}
