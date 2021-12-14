package com.company.fb;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesisofSize_2N {
    static List<String> out = new ArrayList<>();
    public static void main(String[] args) {
        int n =3;
        char[] curr = new char[2*n];
        generateParanthesis(curr,0,2*n);
        out.forEach(System.out::println);
    }

    public static void generateParanthesis(char[] curr, int i,int n){
        if(i==n ){//BASE CONSITIONS
            if(valid(curr)){
                out.add(new String(curr));
            }
            return;
        }
        curr[i] ='(';
        generateParanthesis(curr,i+1,n);
        curr[i] =')';
        generateParanthesis(curr,i+1,n);
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}
