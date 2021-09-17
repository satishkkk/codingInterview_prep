package com.utility.collectionCOnversion;

public class CharacterArray {
    public static void main(String[] args) {
        String s= "ABCDEFGHIJKLMNOPQRSTQVWXYZ";

        char[] charArray = s.toCharArray();

        int[] letters = new int[128];
        for(char c: charArray){
            System.out.println(c);
            letters[c]++;
        }
    }
}
