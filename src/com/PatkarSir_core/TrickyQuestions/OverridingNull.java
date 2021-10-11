package com.PatkarSir_core.TrickyQuestions;

/*
Java will always try to use the most specific applicable version of a method that's available
https://stackoverflow.com/questions/5229809/method-overloading-for-null-argument
*/
public class OverridingNull {
    public static void main(String[] args) {
        method(null); //Java will always try to use the most specific applicable version of a method that's available
        /*So here string is more specific then object hence it will call string method*/
    }
    public static void method(Object o) {
        System.out.println("Object method");
    }
    public static void method(String s) {
        System.out.println("String method");
    }
    /*This will give compile time error as ambiguous method call for parameetr rnull
    * because string and inr=terger are more specific to Object */
//    public static void method(Integer s) {
//        System.out.println("Integer method");
//    }
}
