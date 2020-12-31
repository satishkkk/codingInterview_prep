package com.coding.codingninja;

public class FindUniqueElement {
    public static void main(String[] args) {
        int[] in = new int [] {2,3,1,6,3,6,2};
        findUnique(in);
    }

    public static void findUnique(int[] in){
        int answer=0;
        for(int i=0;i<in.length;i++){
            answer = in[i]^answer;
        }
        System.out.println(answer);
    }

}
