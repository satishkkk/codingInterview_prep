package com.coding.DP1;

//https://leetcode.com/problems/coin-change/solution/
public class A7CoinChangeMinimumNumberOfCoin {

    public static void main(String[] args) {
        int[] coins=new int[]{1,2};
        int amount = 3;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        return recursionHelper(coins,amount);
    }

    public static int recursionHelper(int[] coins, int remain){
        if(remain==0) return 0;
        if(remain <0) return -1;

        int minCount = Integer.MAX_VALUE;

        for(int coin : coins){
            int count=recursionHelper(coins,remain-coin);
            if(count==-1) continue;
            minCount = Math.min(minCount,count+1);
        }
        return minCount==Integer.MAX_VALUE?-1 : minCount;
    }
}
