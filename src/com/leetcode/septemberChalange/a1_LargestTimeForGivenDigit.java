package com.leetcode.septemberChalange;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class a1_LargestTimeForGivenDigit {
    public static void main(String[] args) {
        int[] A = new int[]{0,4,0,0};
        String s = largestTimeFromDigits(A);
        System.out.println(s);
    }

    private static String largestTimeFromDigits(int[] A) {
        List<Integer> max = new ArrayList<>(Arrays.asList(2,3,5,9));
        List<Integer> inputList =  Arrays.stream(A).boxed().collect(Collectors.toList());

        String out = "";

        for(Integer maxInt : max){
            Integer temp = -1;
            for(Integer in : inputList){
                if(in <= maxInt && temp < in){
                    temp = in;
                }
            }
            if(temp==-1)
                return "";
            else{
                out = out.concat(Integer.toString(temp));
                inputList.remove(temp);
            }
        }
        out = out.substring(0,2)+":"+out.substring(2,4);
        return out;
    }
}


/*
*
 *
  * LEETCODE SEPTEMBER CHALLANGE DAY 1:
  *
  * Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""


Note:

A.length == 4
0 <= A[i] <= 9

*/




