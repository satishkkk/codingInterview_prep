package com.coding.DP3;

public class A3_CoinSumInfinite {
    public static void main(String[] args) {

        int[] denominator = new int[]{1,2,3};
        int sum = 4;
//        int out = coinSumInfiniteNum(denominator,sum,0);
//        System.out.println(out);
    }

    public static int coinSumInfiniteNum(int[] denominator,int sum){
        if(sum==0) return 1;
        if(sum<0) return 0;

        for(int i=0;i<denominator.length;i++){
            if(sum-denominator[i] >=0){
                return coinSumInfiniteNum(denominator,sum-denominator[i]);
            }
        }
        return 0;
    }

}
