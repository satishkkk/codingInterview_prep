package com.coding.recursion.advance;

import java.util.ArrayList;
import java.util.List;

public class A1subsequenceOfString_Subset_Recursion_Advance {
    private static List<String> outList = new ArrayList<>();

    public static void main(String[] args) {
        String str = "abc";
        subset(str);
        outList.forEach(System.out::println);
    }

    static void subset(String str) {
        if (str.length() == 0) {//base condition
            outList.add("");
            return;
        }
        subset(str.substring(1));// hypothesis - smaller sub problems
        int n = outList.size();
        for (int i = 0; i < n; i++) {
            outList.add(str.charAt(0) + outList.get(i)); //induction. . .
        }
    }


}
