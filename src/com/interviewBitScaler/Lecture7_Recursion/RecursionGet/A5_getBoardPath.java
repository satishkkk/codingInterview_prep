package com.interviewBitScaler.Lecture7_Recursion.RecursionGet;

import java.util.ArrayList;

public class A5_getBoardPath {

    /*
    *     10
    * 7 8 9
    * 4 5 6
    * 1 2 3
    *
    * Find all possible ways to go from start index(1) to end index(10) .
    * */

    public static void main(String[] args) {
        System.out.println("--------------PRINT -------------------");
        printBoardPath(1,3,"");
        System.out.println("--------------Count -------------------");
        System.out.println(countBoardPath(1,3));
        System.out.println("--------------GET -------------------");
        ArrayList<String> out = getBoardPath(0,3);
        out.stream().forEach(System.out::println);

    }

    public static void printBoardPath(int curr , int end,String ans){
        if(end==curr){
            System.out.println(ans);
            return;
        }

        if(curr>end){
            return;
        }
        for (int dice = 1; dice <= 6; dice++) {
            printBoardPath(curr+dice,end,ans+dice);
        }

    }

    public static int countBoardPath(int curr , int end){

        if(end==curr){
            //contribute to the count
            return 1;
        }

        if(curr>end){
            //do not contribute to the count
            return 0;
        }

        int count =0;

        for (int dice = 1; dice <= 6; dice++) {
            count += countBoardPath(curr+dice,end);
        }

        return count;
    }

    public static ArrayList<String> getBoardPath(int curr , int end){

        if(end==curr){
            //contibute to the mr
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if(curr>end){
            //do not contribute to the array
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        ArrayList<String> mr = new ArrayList<>();

        for (int dice = 1; dice <= 6; dice++) {
           ArrayList<String> rr = getBoardPath(curr+dice,end); // from each value generate 6 different call. . .
           for(String s : rr){
               mr.add(dice+s);
           }
        }

        return mr;
    }
}
