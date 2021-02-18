package com.coding.backtracking;

public class NQueenProblem {

    public static void nQueenHelper(int[][] board,int row,int n){

        if(row==n){
            print(board,n);
        }

        for(int col=0;  col<n; col++){
            if(isValid(board,row,col,n)){
                board[row][col]=1;
                nQueenHelper(board,row+1,n);
                board[row][col]=0;
            }
        }

    }

    //print function
    static void print(int[][] board,int n){
        StringBuilder str = new StringBuilder();
        for(int i=0 ;i<n;i++){
            for(int j=0;j<n;j++){
                str.append(board[i][j]);
            }
            System.out.println(str);
            str.delete(0,4);
        }
        System.out.println("\n");
    }

    //isValid function
    static boolean isValid(int[][] board , int row,int col,int n){
        int i, j;

        /* Check vertically first */
        for (i = 0; i <= row; i++)
            if (board[i][col] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j < n && i>=0; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    public static void main(String[] args) {
        int n =4;
        int [][] board = new int[n][n];
        nQueenHelper(board,0,n);
    }

}
