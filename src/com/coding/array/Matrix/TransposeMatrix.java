package com.coding.array.Matrix;

public class TransposeMatrix {
    public static void main(String[] args) {
        int n=3;
        int A[][] = new int[][]{ {1,2,3}, {4,5,6}, {7,8,9} };
        transpos(A);
        print(A);
        reverse(A);
        print(A);
    }

    static void transpos(int A[][]){
        for(int i=0;i<A[0].length;i++){
            for(int j=i;j<A[0].length;j++){
                swap(A,i,j,j,i);
            }
        }
    }

    static void reverse(int A[][]){
        for(int i=0;i<A[0].length;i++){
            for(int j=0;j<A[0].length/2;j++){
                swap(A,i,j,i,A[i].length-1-j);
            }
        }
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

    static void swap (int[][] A, int i1,int j1,int i2,int j2){
        int temp = A[i1][j1];
        A[i1][j1] = A[i2][j2];
        A[i2][j2] = temp;
    }
}
