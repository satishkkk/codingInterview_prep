package com.interviewBitScaler.Lecture4_BITMANIPULATION;

public class FindTwoUniqueElement {
    public static void main(String[] args) {
        int d = 5;
        d &= -d;
        System.out.println(d);
    }
}
