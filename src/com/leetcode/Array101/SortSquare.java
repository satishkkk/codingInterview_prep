package com.leetcode.Array101;

import java.util.*;

public class SortSquare {
    public static void main(String[] args) {
//        int[] arr= new int[]{-4,-1,0,3,10};
//        int[] ans =   sortedSquares(arr);
//        Arrays.stream(ans).forEach(System.out::println);
        System.out.println(findLength1("araaci", 1));

    }

    public static int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).map(i->i*i).sorted().toArray();
    }

    public static int findLength(String str, int k) {
        // TODO: Write your code here
        int n = str.length();
        int startIndex = 0;
        int maxLength =0;
        Map<Character,Integer> map = new HashMap<>();

        for(int endIndex=0;endIndex<n;endIndex++){
            Character characterAtEndIndex = str.charAt(endIndex);


            if(map.containsKey(characterAtEndIndex)){
                maxLength= Math.max(maxLength,endIndex-startIndex+1);
            }else if(!map.containsKey(characterAtEndIndex)  && map.size() < k){
                maxLength= Math.max(maxLength,endIndex-startIndex+1);
                map.put(characterAtEndIndex,1);
            }else if(map.size() ==k){
                while(map.size() == k){
                    Character characterAtStartIndex = str.charAt(startIndex);
                    if(map.containsKey(characterAtStartIndex)) map.remove(characterAtStartIndex);
                    startIndex++;
                }
            }
        }

        return -1;
    }


    public static int findLength1(String str, int k) {
        // TODO: Write your code here
        int n = str.length();
        int startIndex = 0;
        int maxLength =0;
        Map<Character,Integer> map = new HashMap<>();

        for(int endIndex=0;endIndex<n;endIndex++){
            char characterAtEndIndex = str.charAt(endIndex);
            map.put(characterAtEndIndex,map.getOrDefault(characterAtEndIndex,0)+1);

            while(map.size() > k){
                Character characterAtStartIndex = str.charAt(startIndex);
                if(map.containsKey(characterAtStartIndex)){
                    if(map.get(characterAtStartIndex)==1) map.remove(characterAtStartIndex);
                    else map.put(characterAtStartIndex,map.get(characterAtStartIndex)-1);
                }
                startIndex++;
            }
            maxLength= Math.max(maxLength,endIndex-startIndex+1);
        }

        return maxLength ;
    }
}

