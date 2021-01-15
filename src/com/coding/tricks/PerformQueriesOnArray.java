package com.coding.tricks;

import java.util.ArrayList;
import java.util.List;

class query {
    int startIndex;
    int endIndex;

    public query(int startIndex, int endIndex){
        this.startIndex=startIndex;
        this.endIndex=endIndex;
    }
}


public class PerformQueriesOnArray {

    public static void main(String[] args) {
        List<query> queryList = new ArrayList<>();
        queryList.add(new query(2,3));
        queryList.add(new query(1,5));
        queryList.add(new query(5,8));

        int[] in = new int[1000];

        PerformQueriesOnArray o =new PerformQueriesOnArray();
        int[] out= o.performQuery(in , queryList);
        o.print(out);
    }

    /*
    update array as following
    startelement as +1 and
    endelement+1 to -1
    prefix sum of each elemnt in array
    */

    int[] performQuery(int[] in, List<query> queryList){
        for(query q : queryList){
            in[q.startIndex] = in[q.startIndex]+1;
            if(q.endIndex+1 <= in.length)
                in[q.endIndex+1]= in[q.endIndex+1]-1;
        }

        int cur;
        int prev=0;
        for(int i=0 ; i<in.length;i++){
            cur= in[i];
            in[i]= cur+prev;
            prev = in[i];
        }
        return in;
    }

    public void print (int[] p){
        for(int a : p){
            System.out.println(a);
        }
    }
}

