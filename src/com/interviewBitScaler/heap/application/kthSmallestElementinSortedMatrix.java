package com.interviewBitScaler.heap.application;

import java.util.PriorityQueue;

public class kthSmallestElementinSortedMatrix {
    public static void main(String[] args) {
        int[][] in = new int[2][3];
        in[0] = new int[]{9, 11, 15};
        in[1] = new int[]{10, 15, 17};

        int B =6;
        System.out.println(solve(in,B));
    }

    public static int solve(int[][] A, int B) {

        PriorityQueue<int[]> pq = new PriorityQueue<>( (p, q) -> p[2]-q[2] );

        int row = A.length;
        int column = A[0].length;

        for(int i=0;i<row;i++){
            pq.add(new int[]{i,0, A[i][0]});
        }

        int[] temp = new int[3];
        while(B>0){
            temp = pq.poll();
            int r = temp[0];
            int c = temp[1];
            if(r<row && c+1<column)
                pq.add( new int[]{ r,c+1,A[r][c+1] } );
            B--;
        }

        return temp[2];
    }
}
