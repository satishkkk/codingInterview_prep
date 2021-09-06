package com.interviewBitScaler.Lecture21_Stack1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class HighestFrequencyStack {
    public static void main(String[] args) {
        int[][] in = new int[][]{
                new int[]{1,4},
                new int[]{2,0},
                new int[]{1,9},
                new int[]{2,0},
                new int[]{1,6},
                new int[]{1,6},
                new int[]{2,0}
        };
        int[] out = solve(in);
        Arrays.stream(out).forEach(System.out::println);
    }

    public static  int[] solve(int[][] A) {
        int n = A.length;
        int[] out = new int[n];

        Map<Integer,Integer> frequencyMap = new HashMap<>();
        Map<Integer, Stack<Integer>> stackMap = new HashMap<>();
        int frequency =0 ;

        for(int i=0;i<n;i++){
            int operation = A[i][0];
            int value = A[i][1];

            if(operation == 1){
                //push
                int count = frequencyMap.getOrDefault(value,0);
                frequencyMap.put(value,count+1);
                if(stackMap.containsKey(count+1)){
                    stackMap.get(count+1).push(value);
                }else{
                    Stack<Integer> s = new Stack<Integer>();
                    s.push(value);
                    stackMap.put(count+1,s);
                    frequency++;
                }
                out[i]=-1;
            }else{
                //pop
                if(stackMap.get(frequency).isEmpty()){
                    stackMap.remove(frequency);
                    frequency--;
                }

                int highestFrequencyElement = stackMap.get(frequency).pop();
                out[i] = highestFrequencyElement;
                int frequencyCount = frequencyMap.getOrDefault(highestFrequencyElement,0);
                if(frequencyCount!=0){
                    frequencyMap.put(highestFrequencyElement,frequencyCount-1);
                }
            }
        }
        return out;

    }
}
