package com.interviewBitScaler.greedy;

import java.util.ArrayList;

public class FinishMaximumJob {
    public static void main(String[] args) {
    int[] A = new int[]{1, 5, 7, 1};
    int[] B = new int[]{7, 8, 8, 8};
        System.out.println(solve(A,B));
    }

    public static int solve(int[] A, int[] B) {
        int n=A.length;
        ArrayList<Info1> list  = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Info1(A[i],B[i]));
        }
        list.sort((info1,info2) -> info1.endTime-info2.endTime);

        int ans = 0;
        int previousEndTime = 0;
        for(int i=0;i<n;i++){
            Info1 current = list.get(i);
            if(current.startTime >= previousEndTime){
                ans++;
                previousEndTime=current.endTime;
            }
        }
        return ans;

    }
}

class Info1{
    int startTime;
    int endTime;

    Info1(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime =endTime;
    }
}
