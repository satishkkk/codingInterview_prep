package com.coding.mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

public class mergeOverlappingIntervals {
    public static void main(String[] args) {

        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : mergeOverlappingIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : mergeOverlappingIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : mergeOverlappingIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }


    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        // TODO: Write your code here
        Collections.sort(mergedIntervals, (a, b) -> a.start-b.start);

        if(intervals.size()<2) return intervals;
        Interval first = intervals.get(0);
        Interval second = intervals.get(1);

        for(int i=1;i<intervals.size();i++){
            if(first.end >= second.start){//overlap
                mergedIntervals.add(new Interval(first.start,Math.max(first.end,second.end)));
            }else{
                mergedIntervals.add(first);
            }
            first = mergedIntervals.get(mergedIntervals.size()-1);
            second = intervals.get(i);
        }

        return mergedIntervals;
    }


}
