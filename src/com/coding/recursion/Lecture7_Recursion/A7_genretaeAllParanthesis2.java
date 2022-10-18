package com.coding.recursion.Lecture7_Recursion;

import java.util.ArrayList;

public class A7_genretaeAllParanthesis2 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    static ArrayList < String > ans;

    public static ArrayList< String > generateParenthesis(int A) {
        ans = new ArrayList < > ();
        generateParanthesis(new StringBuilder(), 0, 0, A);
        return ans;
    }


    public static void generateParanthesis(StringBuilder sb , int countOpen , int countClose, int n){

        //valid base case
        if(countOpen==countClose && countOpen == n){
            ans.add(sb.toString());
            return;
        }

        //invalid base case
        if(countOpen> n || countClose >n) {
            return;
        }

        // Now we have 2 options. We can either add '(' to the string or add ')' to the string.
        // Option 1. Add '('
        //choice 1 : select open bracket
        if(countOpen < n){
            sb.append('(');
            generateParanthesis(sb,countOpen+1,countClose,n);
//            sb.deleteCharAt(sb.length());
            sb.setLength(sb.length()-1);
        }

        //choice 2 : Add ')'
        if(countOpen > countClose){
            sb.append(')');
            generateParanthesis(sb,countOpen,countClose+1,n);
//            sb.deleteCharAt(sb.length());
            sb.setLength(sb.length()-1);
        }

    }
}

/**
 * Problem Description
 * Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 10
 *
 *
 *
 * Input Format
 * First and only argument is integer A.
 *
 *
 *
 * Output Format
 * Return a sorted list of all possible parenthesis.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 3
 * Input 2:
 *
 * A = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * Output 2:
 *
 * [ "()" ]
 * */