package com.company.intuit;

public class Test2 {

    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1,2,2,1,1,1,1},{1,2,2,1,2,2,1},{1,1,1,1,2,2,1}};
        int[][] grid = new int[][]{{0,5,5,1,1,1,1},{1,5,5,1,5,5,1},{1,1,1,1,5,5,1}};
        int out = minPathSum(grid);
        System.out.println(out);
    }

    public static int minPathSum(int[][] grid) {


        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1){
                    int val=0;
                    if (i >=0 && i< grid.length && i-1 >=0 && i-1 < grid.length && j>=0 && j< grid[0].length && j-1>=0 && j-1 < grid[0].length){
                        val = Math.min(Integer.MAX_VALUE,Math.min(dp[i][j-1],dp[i - 1][j]) );
                    }
                    dp[i][j] = grid[i][j] + Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), val==0 ? Integer.MAX_VALUE : val);
                }
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }

}
