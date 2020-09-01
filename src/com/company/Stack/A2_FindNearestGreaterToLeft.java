package com.company.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class A2_FindNearestGreaterToLeft {
    /*
     * Given an array, print the Next Greater Element (NGE) for every element.
     * The Next greater Element for an element x is the first greater element on the LEFT side of x in array.
     * Elements for which no greater element exist, consider next greater element as -1.
     */
    int[] nearestGreterToLeft(int[] in) {
        List<Integer> out = new ArrayList<>();

        Stack<Integer> stack = new Stack<Integer>();

        for (int i =0 ; i<in.length;i++) {
            if (stack.isEmpty()) {
                out.add(-1);
            }
            else if (!stack.isEmpty() && stack.peek() > in[i] ) {
                out.add(stack.peek());
            }
            else {
                while (!stack.empty() && stack.peek() <in[i] ) {
                    stack.pop();
                }

                if (!stack.empty() && in[i] < stack.peek()) {
                    out.add(stack.peek());
                }

                if (stack.isEmpty()) {
                    out.add(-1);
                }
            }
            stack.push(in[i]);
        }
//        Collections.reverse(out);
        return out.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] in = new int[]{5,9,1,59,25,68};

        A2_FindNearestGreaterToLeft GTR = new A2_FindNearestGreaterToLeft();
        int[] out = GTR.nearestGreterToLeft(in);
        for(int i=0;i<out.length;i++)
            System.out.println(out[i]);
//        Arrays.asList(out).forEach(n -> System.out.println(n));
    }


}
