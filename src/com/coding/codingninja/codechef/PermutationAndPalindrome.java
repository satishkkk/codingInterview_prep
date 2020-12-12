package com.coding.codingninja.codechef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationAndPalindrome {
    public static void main(String[] args) {
        findPalindrome("abab");
    }

    public static void findPalindrome(String s) {

        Map<Character, ArrayList<Integer>> map = new HashMap();
//        ArrayList<Integer> freq[]=new ArrayList[26]; // you can also try this datastructure . . . array of ArrayList
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (map.get(c[i]) == null) {
                map.put(c[i], new ArrayList<>(Arrays.asList(i + 1)));
            } else {
                ArrayList<Integer> al = map.get(c[i]);
                al.add(i + 1);
                map.put(c[i], al);
            }
        }

        int oddCount = 0;
        int[] out = new int[c.length];
        int start = 0;
        int end = c.length - 1;

        for (int i = 0; i < 26; i++) {
            if (map.get(getChar(i)) != null) {
                ArrayList<Integer> al = map.get(getChar(i));
                if (al.size() % 2 == 1) {
                    oddCount++;
                    if (oddCount > 1) {
                        System.out.println("CAN'T MAKE PALINDROM. . . ");
                        return;
                    }
                }

                for (int j = 0; j < al.size(); j += 2) {
                    out[start] = al.get(j);
                    start++;
                    if (al.size() != 1) {
                        out[end] = al.get(j + 1);
                        end--;
                    }
                }
                if (oddCount != 0)
                    out[(c.length / 2)] = al.get(al.size() - 1);
            }
        }

        Arrays.stream(out).forEach(i -> System.out.println(i));
    }


    public static char getChar(int i) {
        return (char) (i + 'a');
    }
}
