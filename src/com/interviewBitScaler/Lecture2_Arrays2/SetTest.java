package com.interviewBitScaler.Lecture2_Arrays2;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set<List<Integer>> res = new HashSet<>();

        res.add(new ArrayList<>(Arrays.asList(1,2,3)));
        res.add(new ArrayList<>(Arrays.asList(1,3,3)));
        res.add(new ArrayList<>(Arrays.asList(1,2,3)));
        System.out.println(res.size());
    }
}
