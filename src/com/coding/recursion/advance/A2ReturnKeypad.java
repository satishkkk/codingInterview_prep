package com.coding.recursion.advance;

import java.util.*;

public class A2ReturnKeypad {

    public static Map<Integer,String> keypadMap = new HashMap<Integer, String>(){{
        put(2,"abc");
        put(3,"def");
        put(4,"ghi");
        put(5,"jkl");
        put(6,"mno");
        put(7,"pqrs");
        put(8,"tuv");
        put(9,"wxyz");
        put(0," ");
        put(1," ");
    }};

    public static void main(String[] args) {
        int num = 134;
        String[] out1 = keypad(num);
        Arrays.stream(out1).forEach(System.out::println);
//        String arr[] = new String[1000];
//        int n =getKeypadSubsequence(num,arr);
//        System.out.println(n);
    }

    public static String[] keypad(int n){
        if(n==0){//base
            String out[] = {""};
            return out;
        }

        //hypo
        String smallerNumberArray[] = keypad(n/10);

        //Induction
        char singleDigitOutput[] = keypadMap.get(n%10).toCharArray();
        String output[] = new String[smallerNumberArray.length*singleDigitOutput.length];

        int k=0;
        for(int i=0;i<singleDigitOutput.length;i++){
            for(int j=0;j<smallerNumberArray.length;j++){
                output[k]=smallerNumberArray[j]+singleDigitOutput[i];
                k++;
            }
        }
        return output;
    }



    public static int getKeypadSubsequence(int num,String[] out){
        //base case
        if(num == 0){
            out[0]="";
            return 1;
        }

        int lastDigit = num%10;
        int smallNumber = num/10;

        String smallOutput[] = new String[500];
        //hypothesis
        int smallCount = getKeypadSubsequence(smallNumber,smallOutput);

        int k=0;
        //induction
        char[] options =keypadMap.get(lastDigit).toCharArray();
        for(int i=0;i<options.length;i++){
            for(int j=0;j<smallCount;j++){
                out[k] = smallOutput[j]+options[i];
            }
        }
        return smallCount*options.length;
    }
}
