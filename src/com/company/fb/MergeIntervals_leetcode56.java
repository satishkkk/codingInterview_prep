package com.company.fb;

import java.awt.print.PrinterGraphics;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals_leetcode56 {
    public static void main(String[] args) {


        int[][] a = {{1,3},{8,10},{2,6},{15,18}};
        int[][] out = merge(a);
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> out = new LinkedList<>();

        for(int[] interval : intervals){
            if(out.isEmpty() || out.getLast()[1] < interval[0]){
                out.add(interval);
            }else{
                out.getLast()[1] = Math.max(out.getLast()[1], interval[1]);
            }
        }

        return out.toArray(new int[out.size()][]);
    }
}
