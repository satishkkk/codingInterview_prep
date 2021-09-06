package com.interviewBitScaler.LectureX1_String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BoringSubstring {
    public static void main(String[] args) {
        String s = "nmnn";
        System.out.println(solve(s));
    }

    public static int solve(String A) {

        char leftMin='{';
        char rightMin='{';
        char leftMax='Z';
        char rightMax='Z';

        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);

            if(ch%2==0){
                if(Character.compare(ch,leftMin)<0){
                    leftMin = ch;
                }
                if(Character.compare(ch,leftMax)>0){
                    leftMax = ch;
                }
            }else{
                if(Character.compare(ch,rightMin)<0){
                    rightMin = ch;
                }
                if(Character.compare(ch,rightMax)>0){
                    rightMax = ch;
                }
            }

        }

        if(Math.abs(leftMax-rightMin)!=1 || Math.abs(rightMax-leftMin)!=1)
            return 1;
        else
            return 0;

    }
}
