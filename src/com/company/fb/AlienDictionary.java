package com.company.fb;

public class AlienDictionary {

    public static void main(String[] args) {
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words = new String[]{"hello","leetcode"};
        System.out.println(isAlienSorted(words,order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        for(int i=0;i<26;i++){
            char ch = order.charAt(i);
            dict[ch-'a'] = i;
        }

        for(int i=0;i<words.length-1;i++){
            if(!isValid(words[i],words[i+1],dict)){
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(String word1,String word2,int[] dict){
        for(int i=0;i<word1.length() && i<word2.length();i++){
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            if(ch1==ch2){
                continue;
            }
            if(dict[ch1-'a'] > dict[ch2-'a']){
                return false;
            }else{
                return true;
            }
        }
        if(word1.length() > word2.length()) return false;
        return true;
    }
}
