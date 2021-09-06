package com.interviewBitScaler.LectureX1_String;

import java.util.ArrayList;
import java.util.List;

public class CyclicPermutation {

    public static void main(String[] args) {
        cyclicString("111","111");
    }

    public static int cyclicString(String A,String B){
//        List<String> list = new ArrayList<>();
        int count=0;
        int n = B.length();
        for(int i=0;i<n;i++){
            char ch = B.charAt(n-1);
            String temp = new String(ch+B.substring(0,n-1));
            if(A.equals(temp)){
                count++;
            }
//            list.add(temp);
            B=temp;
        }
        return count;
    }
}
