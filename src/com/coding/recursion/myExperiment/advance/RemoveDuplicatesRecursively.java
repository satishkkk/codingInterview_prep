package com.coding.recursion.myExperiment.advance;

public class RemoveDuplicatesRecursively {
    public static void main(String[] args) {
        String out = removeConsecutiveDuplicates("aaabbbbaaaaccccd");
        System.out.println(out);
    }

    public static String removeConsecutiveDuplicates(String s) {
        if(s.length()==1)
            return s;
        if(s.charAt(0) == s.charAt(1)){
            return removeConsecutiveDuplicates(s.substring(1));
        }
        return s.charAt(0)+removeConsecutiveDuplicates(s.substring(1));
    }

}
