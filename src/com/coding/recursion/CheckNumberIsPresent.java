package com.coding.recursion;

import java.util.Scanner;

public class CheckNumberIsPresent {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int input[] = new int[n];
        for(int i = 0; i < n; i++) {
            input[i] = s.nextInt();
        }
        int x = s.nextInt();
        System.out.println(checkNumber(input, x));
    }


    public static boolean checkNumber(int input[], int x) {

        if(input[input.length-1] == x)
            return true;
        if(input.length == 1 && input[0] != x)
            return false;

        int[] newArray = new int[input.length-1];

        System.arraycopy(input,0,newArray,0,newArray.length);

        return checkNumber(newArray,x);
    }
}
