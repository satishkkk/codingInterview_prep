package com.interviewBitScaler.heap.application;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MishaAndCandy {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(1);
        int B = 2;
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, int B) {

        // if(A.size()==1) {
        // //  if(A.get(0)/2 < B){
        // //     return A.get(0)/2;
        // //  }
        //     return 0;
        // }

        int ans = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Integer i : A) {
            minHeap.add(i);
        }
        // int min = minHeap.poll();

        while (!minHeap.isEmpty()) {
            int min = minHeap.poll();
            if (min <= B) {
                ans += min / 2;
                int remaining = min - (min / 2);
                if (!minHeap.isEmpty()) {
                    int temp = minHeap.poll();
                    temp += remaining;
                    if (temp <= B) {
                        minHeap.add(temp);
                    }
                }else
                    return ans;
            }

        }
        return ans;

    }
}
