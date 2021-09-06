package com.interviewBitScaler.Lecture6_BinarySearchApplication;

public class PartitionPainterProblem {
    public static void main(String[] args) {
        int A=3;
        int B=10;
        int C[]= new int[]{185, 186, 938, 558, 655, 461, 441, 234, 902, 681 };
        System.out.println(paint(A,B,C));
    }

    public static int paint(int A, int B, int[] C) {
        int n = C.length;
        int max =0;
        int sum = 0;
        for(int i=0 ;i<n;i++){
            max = Math.max(max,C[i]);
            sum += C[i];
        }
        long ans=Long.MAX_VALUE;
        long start = max*B;
        long end = sum*B;
        while(start <= end){
            long mid = (start+end)/2;
            if(isValid(A,B,C,mid)){
                ans = Math.min(ans,mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return (int)(ans%10000003);
    }

    public static boolean isValid(int A, int B, int[] C,long mid){
        long sum =0;
        int partition =1;
        for(int i=0;i<C.length;i++){
            if( (sum + C[i]*B) < mid){
                sum+=C[i]*B;
            }else{
                partition++;
                sum = C[i]*B;
            }
            if(partition > A)
                return false;
        }
        return true;
    }
}
