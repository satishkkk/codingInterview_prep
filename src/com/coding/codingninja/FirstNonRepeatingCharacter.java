package com.coding.codingninja;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String args[]){
        String input = "aabbccddeeff";
        Map<Character,Integer> wordCountMap = new HashMap<>();
        for(int i =0 ; i<input.length();i++){
            char c = input.charAt(i);
           wordCountMap.put(c,wordCountMap.getOrDefault(c,0)+1); // getorDefaukt Method
        }
        int successFlag = 0;
        for(int i =0 ; i<input.length();i++){
            char c = input.charAt(i);
            if(wordCountMap.get(c) == 1){
                System.out.println("First non repeating characte is at inedx "+i);
                successFlag=1;
                break;
            }
        }
        if(successFlag==0){
            System.out.println("No unique character found");
        }
    }
}
