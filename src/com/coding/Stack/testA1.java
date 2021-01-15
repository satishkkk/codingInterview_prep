package com.coding.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class testA1 {
    /*
     * Given an array, print the Next Greater Element (NGE) for every element.
     * The Next greater Element for an element x is the first greater element on the right side of x in array.
     * Elements for which no greater element exist, consider next greater element as -1.
     */
    List<Integer> nearestGreterToRight(int[] in) {
        List<Integer> out = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=in.length-1;i>=0;i--){
             if(stack.isEmpty()) {
                 out.add(-1);
             }
             else if(!stack.isEmpty() && in[i]< stack.peek()){
                 out.add(stack.peek());
             }else{
                 while(!stack.isEmpty() && in[i]>stack.peek()){
                     stack.pop();
                 }
                 if(!stack.empty() && in[i]< stack.peek()){
                     out.add(stack.peek());
                 }else{
                     out.add(-1);
                 }
             }
            stack.push(in[i]);
        }

        Collections.reverse(out);
        return out;
    }

    public static void main(String[] args) {
        int[] in = new int[]{5,9,1,69,25,68};

        testA1 GTR = new testA1();

        List<Integer> out = GTR.nearestGreterToRight(in);
        out.stream().forEach(a -> System.out.println(a));
    }



}
