package com.codeSignal.samsara;

public class Class1 {
    public static void main(String[] args) {

        System.out.println(permutationOfPalindrome("taco cat"));
    }

    public static boolean permutationOfPalindrome(String s){
        int[] frequencyMap = new int[26];
        for(int i=0;i<s.length();i++){
            char currentChar = s.charAt(i);
            if(validChar(currentChar)){
                frequencyMap[currentChar-'a']++;
            }
        }
        int oddFrequencyCount = 0;

        for(int i=0;i<s.length();i++){
            if(frequencyMap[i]%2!=0) oddFrequencyCount++;
            if(oddFrequencyCount>1) return false;
        }
        return true;
    }

    public static boolean validChar(char ch){
      return Character.isAlphabetic(ch);
    };
}
