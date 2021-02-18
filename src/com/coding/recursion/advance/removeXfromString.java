package com.coding.recursion.advance;

import java.util.Scanner;

public class removeXfromString {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str);
        System.out.println(str.length());
        String out = removeX(str,'x');
        System.out.println(out);
        System.out.println(out.length());
    }

    static String removeX(String str,char x){
        //base condition
        if(str.length()==0){
            return "";
        }
        if(str.charAt(0) == x){
            //Induction
            return removeX(str.substring(1),x);
        }

        //hypothesis
        return str.charAt(0)+removeX(str.substring(1),x);
    }
}
