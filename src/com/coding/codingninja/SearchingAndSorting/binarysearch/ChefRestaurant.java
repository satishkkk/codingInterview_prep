package com.coding.codingninja.SearchingAndSorting.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class ChefRestaurant {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            long test = sc.nextLong();
            while (test > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();

                Range[] arrRange = new Range[n];

                for (int i = 0; i < n; i++) {
                    Range r = new Range(sc.nextLong(), sc.nextLong());
                    arrRange[i] = r;
                }

                long arr[] = new long[m];
                for (int i = 0; i < m; i++) {
                    arr[i] = sc.nextLong();
                }

//                Arrays.sort(arrRange, (Range r1, Range r2) ->  (int) (r1.startTime - r2.startTime));
                Arrays.sort(arrRange, (Range r1, Range r2) ->  Long.compare(r1.startTime,r2.startTime));

                StringBuilder str = new StringBuilder();

                for (int i = 0; i < m; i++) {
                    //your logic goes here
                    str.append(findWaitingTime(arrRange, arr[i]));
                    str.append("\n");
                }
                System.out.println(str);

                test--;
            }
        } catch (Exception e) {
            return;
        }
    }

    static long findWaitingTime(Range[] range, long slot) {
        //find the first position from the range whoes first position is not less then slot . . .
        // [ [2,3], [5,7], [9,10], [20,30] ] ->if slot is 8 then answer is 1
        int sIdx = 0;
        int eIdx = range.length - 1;

        long result = -1;

        while (sIdx <= eIdx) {
            int mIdx = (sIdx + eIdx) / 2;

            if(slot < range[mIdx].endTime){
                result = Math.max(0,range[mIdx].startTime-slot);
                eIdx = mIdx-1;
            }else{
                sIdx = mIdx+1;
            }

        }
        return result;
    }
}

class Range {
    long startTime;
    long endTime;

    public Range(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}


/*
*
i/p
1
4 5
5 7
9 10
2 3
20 30
5
6
7
35
1
o/p
0
0
2
-1
1
* */