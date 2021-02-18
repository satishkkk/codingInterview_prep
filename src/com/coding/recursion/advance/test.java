package com.coding.recursion.advance;

public class test {
    public static void main(String[] args) {
        int n=123;

        while(n>0){
            int digit =n%10;
            n=n/10;
            System.out.println(digit);
        }
    }
}
