package com.interviewBitScaler.heap.application;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5};
        System.out.println(solve(a));
    }

    public static int solve(int[] A) {
        int ans =0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i:A){
            pq.add(i);
        }

        while(pq.size()>=2){
            int min1 = pq.poll();
            int min2 = pq.poll();
            int sum = min1+min2;
//            System.out.println(min1+"+"+min2+" = "+sum );
            ans+=sum;
            pq.add(sum);
        }
//        ans+=pq.poll();

        return ans;
    }
}
