package com.company.Internship;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowcontainingSubstring {
    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec","abc"));
    }

    public static String findSubstring(String str, String pattern) {
        // TODO: Write your code here

        Map<Character,Integer> map =new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            map.put(pattern.charAt(i),map.getOrDefault(pattern.charAt(i),0)+1);
        }
        int start= 0;
        int minLength =Integer.MAX_VALUE;
        int matchedCharLength=0;
        int ansStartIndex=0;

        for(int end=0;end<str.length();end++){
            char endChar = str.charAt(end);

            if(map.containsKey(endChar)){
                if(map.get(endChar)>0) matchedCharLength++;
                map.put(endChar,map.get(endChar)-1);
            }

            while( matchedCharLength==pattern.length() ){
                if(minLength > end-start+1){
                    minLength=end-start+1;
                    ansStartIndex=start;
                }
                //shrink window
                char startChar = str.charAt(start);
                map.put(startChar,map.get(startChar)+1);
                if( map.get(startChar) > 0 ){
                    matchedCharLength--;
                }
                start++;
            }

        }

        return minLength != Integer.MAX_VALUE ?str.substring(ansStartIndex,ansStartIndex+minLength) : "";
    }

}
