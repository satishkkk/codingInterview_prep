package com.coding.Stack;

import java.util.*;

public class balancedStringStack {

    public static void main(String[] args) {
        Map<Character,Set<Character>> map = new HashMap<>();
        map.put('a', new HashSet<>(Arrays.asList('b','c')));
        map.put('b', new HashSet<>(Arrays.asList('d')));
        map.put('e', new HashSet<>(Arrays.asList('f')));
        map.put('g', new HashSet<>(Arrays.asList('h')));
        System.out.println(isBalance("abdceghf",map));
    }

    static boolean isBalance(String str, Map<Character, Set<Character>> dictionary){
        if(str==null || str.length()==0) return true;
        Stack<Character> stack = new Stack<Character>();
        return balanceUtility(str,0,stack,dictionary);
    }



    static boolean balanceUtility(String str,int index,Stack<Character> stack ,Map<Character,Set<Character>> dictionary){
        if( index == str.length() ){
            return stack.isEmpty();
        }

        char currentChar = str.charAt(index);
        boolean isClose = false ,isOpen=false;

        //check for close character
        if( !stack.isEmpty() && dictionary.get(stack.peek()).contains(currentChar) ){
            char pairChar = stack.peek();
            stack.pop();
            isClose =balanceUtility(str,index+1,stack,dictionary);
            stack.push(pairChar);
        }

        //check for open character
        if(dictionary.containsKey(currentChar)){
            stack.push(currentChar);
            isOpen = balanceUtility(str,index+1,stack,dictionary);
        }



        return isClose || isOpen;
    }

}
