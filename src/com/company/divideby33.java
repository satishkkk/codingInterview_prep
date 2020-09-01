package com.company;

public class divideby33 {
    public static void main(String[] args) {

        final int num =100;
        int part = 3;
        System.out.println("fs");
        int chunkSize= num/part;

        int n=1;
        while(n <= num){
            System.out.println(n);
            n=n+chunkSize;
        }

    }
}
