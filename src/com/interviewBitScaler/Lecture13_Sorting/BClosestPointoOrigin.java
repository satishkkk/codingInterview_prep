package com.interviewBitScaler.Lecture13_Sorting;

import java.util.Arrays;

public class BClosestPointoOrigin {

    public static void main(String[] args) {

    }
        public static int[][] solve(int[][] A, int B) {
            int n = A.length;

            Arrays.sort(A, (p1, p2) -> distanceFromOrigin(p1[0],p1[1]).compareTo(distanceFromOrigin(p2[0],p2[1])));
            return new int[][]{A[B]};
        }

        public static Integer distanceFromOrigin(int x,int y){
            return new Integer((int) (Math.sqrt(Math.pow(x,2) + Math.pow(y,2))));
        }


}
