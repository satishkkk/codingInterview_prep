package com.company.Core.stringExample;

public class StringMain {

    public static void main(String[] args) {
        String str1 = new String ("Cat");
        String str2 = new String ("DOG");
        String str3 = new String ("Cat");
        String str4 = null;
        str4 = str3;

        //STRING LITERALS(CONSTANTS). . .
        String s1 = "Cat";
        String s2 = "Dog";
        String s3 = "Cat";
        String s4=s3;

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);

        /* here we are comparing address . . . */
        if(str3 == str4){
            System.out.println(" == :STRINGS ARE EQUALS");
        }else{
            System.out.println("== : STRINGS ARE NOT EQUALS");
        }

        if(str4.equals(str3)){
            System.out.println("EQUALS METHOD : STRINGS ARE EQUALS");
        }else{
            System.out.println("EQUALS METHOD : STRINGS ARE NOT EQUALS");
        }

        /* here we are comparing address . . . */
        if(s1 == s3){
            System.out.println(" == :STRINGS ARE EQUALS");
        }else{
            System.out.println("== : STRINGS ARE NOT EQUALS");
        }

        if(s1.equals(s3)){
            System.out.println("EQUALS METHOD : STRINGS ARE EQUALS");
        }else{
            System.out.println("EQUALS METHOD : STRINGS ARE NOT EQUALS");
        }


    }
}
