package com.interviewBitScaler.Lecture21_Stack1;


import java.util.Arrays;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        int[] a = new int[]{66, 96, 43, 28, 14, 1, 41, 76, 70, 81, 22, 11, 42, 78, 4, 88, 70, 43, 90, 6, 12 };
        int[] out = solve(a);
        Arrays.stream(out).forEach(System.out::println);

    }

    public static int[] solve(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<A.length;i++){
            stack.push(A[i]);
        }

        Stack<Integer> stackOut = sort(stack);
        int[] out = new int[n];
        int i=0;
        while(!stackOut.isEmpty()){
            out[i++]=stackOut.pop();
        }
        return out;
    }

    public static Stack<Integer> sort(Stack<Integer> stack){
        if(stack.isEmpty()){
            return stack;
        }

        Stack<Integer> auxStack = new Stack<Integer>();

        auxStack.push(stack.pop());

        while(!stack.isEmpty()){
            Integer element =stack.pop();
            while(!auxStack.isEmpty() && element<auxStack.peek()){
                stack.push(auxStack.pop());
            }
            auxStack.push(element);
        }

        while(!auxStack.isEmpty()){
            stack.push(auxStack.pop());
        }

        return stack;
    }
//    public static Stack<Integer> sort(Stack<Integer> stack){
//        if(stack.isEmpty()){
//            return stack;
//        }
//
//        Stack<Integer> smallerStack = new Stack<Integer>();
//        Stack<Integer> largerStack = new Stack<Integer>();
//
//        Integer pivot = stack.pop();
//
//        while(!stack.isEmpty()){
//            Integer element =stack.pop();
//            if(element <= pivot) smallerStack.push(element);
//            else largerStack.push(element);
//        }
//
//        sort(smallerStack);
//        sort(largerStack);
//
//        Stack<Integer> auxStack = new Stack<Integer>();
//
//        while(!largerStack.isEmpty()){
//            auxStack.push(largerStack.pop());
//        }
//        smallerStack.push(pivot);
//        while(!auxStack.isEmpty()){
//            smallerStack.push(auxStack.pop());
//        }
//        return smallerStack;
//    }
}
