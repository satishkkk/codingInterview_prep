package com.interviewBitScaler.greedy;

import java.util.*;

public class FreeCars {
    public static void main(String[] args) {
        int[] a =new int[]{ 1, 7, 6, 2, 8, 4, 4, 6, 8, 2};
        int[] b =new int[]{8, 11, 7, 7, 10, 8, 7, 5, 4, 9 };
        List s = Arrays.asList(a);
        Collections.sort(s);
//        s.sort((Integer j,Integer k) -> j-k);
        System.out.println("a");
//        System.out.println(solve(a,b));
    }

    public static  int solve(int[] A, int[] B) {
        int n =A.length;
        ArrayList<Info> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Info(A[i],B[i]));
        }
        list.sort( (info1, info2) -> info1.time - info2.time );
        int out=0;
        int currenttime=0;
        PriorityQueue<Info> pq = new PriorityQueue<>((info1, info2) -> info1.cost - info2.cost);
        for(int i=0;i<list.size();i++){
            Info currentInfo = list.get(i);
            if(currenttime < currentInfo.time){
                out+=currentInfo.cost;
                pq.add(currentInfo);
            }else if(currenttime >= currentInfo.time && pq.peek().cost < currentInfo.cost ){
                Info min = pq.poll();
                out-=min.cost;
                out+=currentInfo.cost;
                pq.add(currentInfo);
            }
            currenttime++;
        }

        return out;
    }
}

class Info{
    int time;
    int cost;
    public Info(int time,int cost){
        this.time = time;
        this.cost = cost;
    }
}
