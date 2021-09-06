package com.interviewBitScaler.DP1;

public class MaxSumWithoutAdjacentElements {
    public static void main(String[] args) {
        int[][] A = new int[2][4];
        A[0] = new int[]{74, 37, 82, 1};
        A[1] = new int[]{66, 38, 16, 1};
        System.out.println(adjacent(A));
    }

    public static int adjacent(int[][] A) {
        int include = Math.max(A[0][0],A[1][0]);
        int exclude = 0;
        int newExclude =0;

        for(int i=1;i<A.length;i++){
            newExclude = Math.max(include,exclude);

            include = exclude+ Math.max(A[0][i],A[1][i]);
            exclude = newExclude;
            System.out.println("E"+exclude);
        }
        return Math.max(include,exclude);

    }
}
