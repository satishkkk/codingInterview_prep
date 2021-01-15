package com.coding.strings;

public class Stringimmutability {
    public static void main(String[] args) {
        String s1 = new String("Satish");
        String s2 = new String("Satish");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
