package com.interviewBitScaler.Graph;

import java.util.LinkedList;
import java.util.Queue;
class Node{
    // int value;
    int x;
    int y;
    int time;

    Node(int x,int y,int time){
        // this.value = value;
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class RottenOrange {

    public static void main(String[] args) {
        int[][] A = new int[][]{{ 0,1}};
        System.out.println(orangesRotting(A));
    }

    public static int[] dx = new int[] {0,-1,0,1};
    public static int[] dy =new int[] {-1,0,1,0} ;

    static boolean isValid(int x, int y, int m,int n){
        if(x >= 0 && x <m && y>=0 && y< n ) return true;
        return false;
    }

    public static int orangesRotting(int[][] grid) {
        int ans = 0;
        int flagAllOnes = 1;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Node> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.add(new Node(i,j,0));
                    flagAllOnes=0;
                }else if(grid[i][j] == 0){
                    flagAllOnes=0;
                }
            }
        }

        if(flagAllOnes==1)  return -1;
        if(queue.isEmpty()) return ans;

        while(!queue.isEmpty()){
            Node current = queue.remove();
            // System.out.println("Current X :"+current.x + " Current Y :"+current.y);
            for(int i=0;i<4;i++){
                if(isValid(current.x + dx[i],current.y+ dy[i],m,n) && grid[current.x + dx[i]][current.y+ dy[i]] == 1){
                    queue.add(new Node(current.x + dx[i],current.y+ dy[i],current.time+1));
                    grid[current.x + dx[i]][current.y+ dy[i]] =2;
                    System.out.println("Grid : X : "+ (current.x + dx[i]) +" Y : "+(current.y+ dy[i])+ "updated to 2");
                    ans = Math.max(ans,current.time+1);
                    System.out.println(ans);
                }
            }

        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    System.out.println("-1 found at X : " + i +" Y : "+ j);
                    return -1;
                }
            }
        }
        return ans;
    }



}
