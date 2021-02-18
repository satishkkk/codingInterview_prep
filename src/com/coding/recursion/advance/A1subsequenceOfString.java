package com.coding.recursion.advance;

import java.util.ArrayList;
import java.util.List;

public class A1subsequenceOfString {
    private static List<String> outList = new ArrayList<>();

    public static void main(String[] args) {
        int count = seq("abc", outList);
        System.out.println(count);
        outList.forEach(System.out::println);
    }

    static int seq(String str, List<String> out) {
        if (str.length() == 0) {
            out.add("");
            return 1;
        }

        String smallerString = str.substring(1);
        int smallerCount = seq(smallerString, out);

        for (int i = 0; i < smallerCount; i++) {
            out.add(str.charAt(0) + out.get(i));
        }

        return 2 * smallerCount;
    }


}
