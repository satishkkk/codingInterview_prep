package com.interviewBitScaler.heap.application;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 719, 983, 9293, 11321, 14447, 16411, 17881, 22079, 28297};
        int b =42;
        int out[] = solve(a,b);
        System.out.println(out[0]);
        System.out.println(out[1]);
    }

    public static int[] solve(int[] A, int B) {

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                (int[] p1, int[] p2) ->  A[p1[0]]*A[p2[1]] - A[p2[0]]*A[p1[1]]
        );

        Set<int[]> set = new TreeSet<>();

        int i=0;
        int j=A.length-1;

        set.add(new int[]{i,j});
        pq.add(new int[]{i,j});

        int[] temp = null;

        while(B>0){
            temp = pq.poll();
            int[] l = new int[]{temp[0]+1,temp[1]};
            int[] r = new int[]{temp[0],temp[1]-1} ;
            if(!set.contains(l)){
                pq.add(l);
                set.add(l);
            }
            if(!set.contains(r)){
                pq.add(r);
                set.add(r);
            }

            B--;
        }
        return new int[]{A[temp[0]],A[temp[1]]};
    }
}
