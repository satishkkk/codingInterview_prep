package com.interviewBitScaler.others;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        int[] arr = new int[]{1,5,5,2,6};
        int n = arr.length;
        System.out.println(longestDistance(arr,n));
    }

    public static int longestDistance(int[] arr , int n){
        int i,j;
        int[] ldsLR= new int[n];

        for(i=1;i<n;i++){
                if(arr[i-1] >= arr[i] ){
                    ldsLR[i] = Math.max(ldsLR[i-1]+1,ldsLR[i]);
                }else{
                    ldsLR[i] =0;
                }
        }

        int[] ldsRL = new int[n];
        for( i=n-2;i>=0;i--) {
                if(arr[i+1] >= arr[i] ){
                    ldsRL[i] = Math.max(ldsRL[i+1]+1,ldsRL[i]);
                }else{
                    ldsRL[i]=0;
                }
        }

        int max = 0;
        for( i=0;i<n;i++){
            max = Math.max(max, (ldsLR[i]+ldsRL[i]+1));
        }

        return max;
    }
}
