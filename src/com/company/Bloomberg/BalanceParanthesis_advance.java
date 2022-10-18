package com.company.Bloomberg;

import java.util.*;

public class BalanceParanthesis_advance {


    public static void main(String[] args) {
        Map<String, Set<String>> dictionary = new HashMap<>();
        dictionary.put("a", new HashSet<>(Arrays.asList("b", "c")));
        dictionary.put("b", new HashSet<>(List.of("d")));
        dictionary.put("e", new HashSet<>(List.of("f")));
        dictionary.put("g", new HashSet<>(List.of("h")));
        System.out.println(dictionary);
        String input = "abdceghf";

        //Your Logic
        Map<String, String> generatedMap = generateMap(dictionary);
        System.out.println(generatedMap);
        System.out.println(isBalance(generatedMap, input));
    }

    public static Map<String, String> generateMap(Map<String, Set<String>> dictionary) {
        Map<String, String> mapping = new HashMap<>();
        //write mapping logic

        for (Map.Entry<String, Set<String>> entry : dictionary.entrySet()) {
            String key = entry.getKey();
            for (String s : entry.getValue()) {
                mapping.put(key + "_O", s + "_C");
                mapping.put(s + "_C", key + "_O");
            }
        }
        return mapping;
    }

    public static boolean isBalance(Map<String, String> mapping, String input) {
        int n = input.length();
        Stack<String> openStack = new Stack<>();
        recursion(mapping, input, openStack, 0);
        return true;
    }

    public static boolean recursion(Map<String, String> mapping, String input, Stack<String> stack, int index) {
        //base case
        if (index == input.length()) {
            return stack.isEmpty();
        }
        String currentChar = Character.toString(input.charAt(index));
        boolean isOpen = mapping.containsKey(currentChar + "_O");
        boolean isClose = mapping.containsKey(currentChar + "_C");
        return true;
    }


//    boolean isBalance(String str, Map<String,Set<String>> dictionary){
//
//        if(str==null || str.length()==0) return true;
//
//        Stack<Character> openStack = new Stack<>();
//
//        return balanceUtility(str,0,openStack,dictionary);
//
//    }
//
//    boolean balanceUtility(String str,int index,Stack<Character> stack ,Map<String,Set<String>> dictionary){
//
//        if(index == str.length()){
//            return stack.isEmpty();
//        }
//
//        char currentchar = str.getCharAt(index);
//
//        boolean isClose = false ,isOpen=false;
//
//        if(dictionary.get(stack.peek()).contains(currentchar)){
//            stack.pop();
//            isClose =balanceUtility(str,index+1,stack,dictionary);
//        }
//
//        if(dictionary.contains(currentchar)){
//            stack.push(currentchar);
//            isOpen = balanceUtility(str,index+1,stack,dictionary);
//        }
//
//        return isClose || isOpen;
//    }
}


/*

"abdceghf"

{
    "a": {"b, c"},
    "b": {"d"},
    "e": {"f"},
    "g": {"h"}
}

abdceghf ->
^
["a","b"]
isopen(b)
isBalcnce(s,open,i)

["a"]

["a", "b"]
[]

isBalcne(s,close,i)

"bd"
*/



/*
"abdceghf"


{
    "a": {"b, c"},
    "b": {"d"},
    "e": {"f"},
    "g": {"h"}
}

*/


/**
 *
 */