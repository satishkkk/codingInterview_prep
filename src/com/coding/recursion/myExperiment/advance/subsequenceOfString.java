package com.coding.recursion.myExperiment.advance;

import java.util.Arrays;

public class subsequenceOfString {
    public static void main(String[] args) {
        String[] out = new String[100];
        int count = seq("abc",out);
        System.out.println(count);
        Arrays.stream(out).forEach(System.out::println);
    }

    static int seq(String str,String[] out){
        if(str.length() == 0){
            out[0] = "";
            return 1;
        }
        
        String smallerString = str.substring(1);
        int smallerCount = seq(smallerString,out);

        for(int i=0;i<smallerCount;i++){
            out[smallerCount+i]=str.charAt(0)+out[i];
        }
        return 2*smallerCount;
    }
}
