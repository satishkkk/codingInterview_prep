package com.PatkarSir_core;

public class A1_PassByvalueJAVAWAY {

    public static void main(String[] args) {
        int x =10;
        modify(x);
        System.out.println(x);
    }

    public static void modify(int data){
        data=20;
    }
}
