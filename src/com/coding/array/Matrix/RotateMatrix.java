package com.coding.array.Matrix;

public class RotateMatrix {
    public static void main(String[] args) {
        int n=3;
        int matrix[][] = new int[][]{ {1,2,3}, {4,5,6}, {7,8,9} };

        print(matrix);
        //ROTATE MATRIX
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-1-i;j++){
                int topleft = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = topleft;
            }
        }


        print(matrix);

    }

    static void print(int A[][]){
        int n = A.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.println(A[i][j]);
            }
            System.out.println("\n");
        }
    }
}
