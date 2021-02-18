package com.coding.recursion.advance;

import java.util.HashMap;
import java.util.Map;

public class A4ReturnKeypadWithoutStoring {
    public static Map<Integer, String> keypadMap = new HashMap<Integer, String>() {{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
        put(0, " ");
        put(1, " ");
    }};

    public static void main(String[] args) {
        int num = 23;
        printKeypad(num, "");
    }

    static void printKeypad(int num, String output) {

        //base case
        if(num == 0){
            System.out.println(output);
            return;
        }

        int smallerNumber = num/10;
        int lastDigit = num%10;

        char[] option = keypadMap.get(lastDigit).toCharArray();

        for(int i=0;i<option.length;i++){
            printKeypad(smallerNumber,Character.toString(option[i])+output);
        }
    }
}
