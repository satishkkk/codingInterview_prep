package com.company.strings;

import java.util.HashSet;
import java.util.Set;

public class StrongPassword {
    public static void main(String[] args) {
        System.out.println(Strongpwd(11,"#HackerRank"));
    }

    static int Strongpwd(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String  lower_case = "abcdefghijklmnopqrstuvwxyz";
        String  special_characters = "!@#$%^&*()-+";

        Set s = new HashSet<String>();
        for (int i=0;i<password.length() && s.size()<4;i++){
            String charToCompare = Character.toString(password.charAt(i));
            if (numbers.contains(charToCompare)) {
                s.add("N");
            } else if (lower_case.contains(charToCompare)) {
                s.add("L");
            } else if (lower_case.toUpperCase().contains(charToCompare)) {
                s.add("U");
            } else if (special_characters.contains(charToCompare)) {
                s.add("S");
            }
        }
        return (n > 6 ?  4-s.size() : Math.max(4 - s.size(), 6 - n));
    }

}
