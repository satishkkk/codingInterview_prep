package com.interviewBitScaler.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {

    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(1,1,1,1,new int[]{0},new int[]{0}));
    }
    // A B are destination
    // c is number of circle
    // d is radius
    // e f center of circle
    static int[] dx = new int[]{0,-1,-1,-1,0,1,1,1};
    static int[] dy = new int[]{-1,-1,0,1,1,1,0,-1};
    public static String solve(int A, int B, int C, int D, int[] E, int[] F) {

        int[][] matrix = new int[A+1][B+1];

        for(int i=0;i<=A;i++){
            for(int j=0;j<=B;j++){
                for(int k=0;k<C;k++){
                    if(//check distance is less then or equal to d
                            Math.abs(Math.sqrt( Math.pow( (i -E[k]),2) + Math.pow( (j-F[k]),2) )) <= D){
                        matrix[i][j] = -1;
                    }
                }
            }
        }

        if(matrix[0][0] == -1 || matrix[A][B] ==-1) return "NO";

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0));

        while(!queue.isEmpty()){
            Pair pair = queue.remove();

            for(int i=0;i<8;i++){
                int newX = pair.x+dx[i];
                int newY = pair.y+dy[i];
                //   System.out.println("X :"+newX+" Y: "+newY);
                if(isValid(newX,newY,A,B) && matrix[newX][newY] != -1){
                    if(newX == A && newY ==B) return "YES";
                    matrix[newX][newY] = -1;
                    queue.add(new Pair(newX,newY));
                }
            }
        }
        return "NO";
    }

    static boolean isValid(int x,int y,int m,int n){
        if(x>=0 && x <= m && y>=0 && y <= n) return true;
        return false;
    }
}

