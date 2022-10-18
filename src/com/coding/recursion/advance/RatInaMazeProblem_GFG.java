package com.coding.recursion.advance;

import java.util.ArrayList;

public class RatInaMazeProblem_GFG {

    public static void main(String[] args) {
        int n=4;
        int[][] m = new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        ArrayList<String> out = findPath(m,n);
        System.out.println(out);
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> out = new ArrayList<>();
        backtrack(m,n,0,0,out);
        return out;
    }

    public static int backtrack(int[][] m, int n , int i, int j,ArrayList<String> out){

        if(i==n-1 && j==n-1) return 1; // reached to the end of the array grid

        if( (j+1 < n) && (m[i][j+1] == 1) ){ // Right
            out.add("R");
            int returFlag = backtrack(m,n,i,j+1,out);

            if(returFlag ==0 ){
                int index = out.size() - 1;
                out.remove(index);
            }
            return 1;
        }

        if( (i+1 < n) && (m[i+1][j] == 1) ){ // Down
            out.add("D");
            int returFlag = backtrack(m,n,i+1,j,out);

            if(returFlag ==0 ){
                int index = out.size() - 1;
                out.remove(index);
            }
            return 1;
        }
        return 0;
    }
}


/**
 * onsider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
 * Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.
 *
 * Example 1:
 *
 * Input:
 * N = 4
 * m[][] = {{1, 0, 0, 0},
 *          {1, 1, 0, 1},
 *          {1, 1, 0, 0},
 *          {0, 1, 1, 1}}
 * Output:
 * DDRDRR DRDDRR
 * Explanation:
 * The rat can reach the destination at
 * (3, 3) from (0, 0) by two paths - DRDDRR
 * and DDRDRR, when printed in sorted order
 * we get DDRDRR DRDDRR.
 * */