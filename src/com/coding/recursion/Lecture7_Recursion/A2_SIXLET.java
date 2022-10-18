package com.coding.recursion.Lecture7_Recursion;

import java.util.ArrayList;
import java.util.List;

public class A2_SIXLET {
    static private int[] A = new int[]{5,17,1000,11};
    static private int B = 4;
    static List<List<Integer>> out = new ArrayList<>();

    public static void main(String[] args) {
//        System.out.println(solve(0, 0, 0));
//        System.out.println(sixlets(0, 0, B));
//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        sixlets1(a,2,0,0);

        System.out.println(sixlets(A,0,0,B));
    }

    static int sixlets(int[] A,int index, int sum, int cnt) {
        if(sum > 1000)  return 0;
        if(cnt == 0)    return 1;
        if(index == A.length)   return 0;

        return sixlets(A,index+1,sum,cnt)+ sixlets(A,index+1,sum+A[index],cnt-1);
    }


    static int sixlets(int i, int sum, int cnt) {

        if(sum > 1000)  return 0;
        if(cnt == 0)    return 1;
        if(i == A.length)   return 0;

        // Take ith element or leave it.
        return sixlets( i+1, sum, cnt) + sixlets( i+1, sum + A[i], cnt-1);
    }


    static int count =0 ;
    public static void sixlets1(ArrayList<Integer> A, int B,int index,int sum){
            if(B==0){
                if(sum < 1000)
                    count++;
                return;
            }else if(index==A.size()){
                return;
            }

            sixlets1(A,B-1,index+1,sum+A.get(index));
            sixlets1(A,B,index+1,sum);
            return;


    }

    private static int solve( int index, int sum, int size) {
        if (size == B)
            return 1;

        int ans = 0;

        for (int i = index; i < A.length; i++) {
            if (sum + A[i] > 1000)
                continue;
            ans += solve(i + 1, sum + A[i], size + 1);
        }
        return ans;
    }
}
