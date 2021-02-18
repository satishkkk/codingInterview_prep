package com.coding.recursion;

import java.util.Scanner;

public class lastIndex {


    static Scanner s = new Scanner(System.in);

    public static int[] takeInput(){
        int size = s.nextInt();
        int[] input = new int[size];
        for(int i = 0; i < size; i++){
            input[i] = s.nextInt();
        }
        return input;
    }

    public static void main(String[] args) {
        int[] input = takeInput();
        int x = s.nextInt();
        System.out.println(lastIndex(input, x));
    }

    public static int lastIndex(int input[], int x) {

        return lastIndex( input,  x , 0);
    }

    public static int lastIndex(int input[], int x,int startIndex) {
        int lastIndex = -1;

        if(startIndex == input.length && lastIndex == -1)
            return -1;

        if(input[startIndex] == x)
            lastIndex = startIndex;

        int newLastIndex = lastIndex(input,x,startIndex+1);

        return newLastIndex>lastIndex ? newLastIndex:lastIndex;

    }
}
