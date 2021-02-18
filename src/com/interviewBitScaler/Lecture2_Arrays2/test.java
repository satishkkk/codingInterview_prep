package com.interviewBitScaler.Lecture2_Arrays2;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        int[][] arr = new int[100][100]; //static array

        ArrayList<Integer>[] arr1 =new ArrayList[100];

        arr1[0] = new ArrayList<>();
        arr1[0].add(1); // it is same as arr[0][0]


        ArrayList<ArrayList<Integer>> arr2 = new ArrayList<>();

    }
}
