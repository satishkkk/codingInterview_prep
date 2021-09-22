package com.company.samsara;

public class RotateMatrix {
    public static void main(String[] args) {
        int [][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        rotateMatrix(a);
        transpose(a);
        reverse(a);
        printMatrix(a);

    }

    static void rotateMatrix(int[][] a){
        int n = a.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-1-i;j++){
                int temp = a[i][j];
                a[i][j] = a[n-1-i][j];
                a[n-1-i][j] = a[n-1-i][n-1-j];
                a[n-1-i][n-1-j] = a[i][n-1-j];
                a[i][n-1-j] = temp;
            }
        }
    }

    static void transpose(int[][] a){
        int n = a.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
    }

    static void reverse(int[][] a){
        int n = a.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = a[i][j];
                a[i][j] = a[i][n-1-j];
                a[i][n-1-j] = temp;
            }
        }
    }
    static void printMatrix(int[][] a){
        int n = a.length;
        int m = a[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.printf("%s  ",a[i][j]);
            }
            System.out.println(" ");
        }
    }

}
