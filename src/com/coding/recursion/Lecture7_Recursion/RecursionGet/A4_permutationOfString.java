package com.coding.recursion.Lecture7_Recursion.RecursionGet;

import java.util.ArrayList;

public class A4_permutationOfString {

    public static void main(String[] args) {
        System.out.println("----------------1 st  method print --------------------");
        printPermutation("abc","");

        System.out.println("----------------2 nd method get --------------------");
        ArrayList<String> a= permutation("abc");
        a.stream().forEach(System.out::println);
    }

    public static void printPermutation (String in,String out){
        if(in.length() == 0){
            System.out.println(out);
            return;
        }

        for(int i=0;i<in.length();i++){
            char ch = in.charAt(i);
            String restOfTheInpput = in.substring(0,i) + in.substring(i+1); //delete i th character from the string
            printPermutation(restOfTheInpput,out+ch);
        }
    }


    //get
    public static ArrayList<String> permutation (String s){
        if(s.length()==0){
            ArrayList<String> br = new ArrayList<>();
            br.add(" ");
            return br;
        }
        Character ch= s.charAt(0); // get character 1
        String ros = s.substring(1); //smaller input
        ArrayList<String> rr = permutation(ros); //we are getting rr them we modify it and create our own mr and returning mr

        ArrayList<String> mr = new ArrayList<>();
        for(String rrs : rr){
            for(int i =0 ;i<rrs.length();i++){
                String val = rrs.substring(0,i)+ch+rrs.substring(i); // append character at all possible positions
                mr.add(val);
            }
        }
        return mr;

    }
}

//