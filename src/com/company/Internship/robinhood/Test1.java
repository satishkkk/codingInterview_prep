package com.company.Internship.robinhood;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(reduceTheNumber("1111122222",3));

        List<Integer> list = new ArrayList<>();
        int[] out = new int[list.size()];
        list.toArray(new int[][]{out});
//        return out;

    }

   static String reduceTheNumber(String number, int k) {
        while(number.length()>k){
            // BigInteger number = BigInteger.valueOf(0);
            StringBuffer sb =new StringBuffer("");
            List<String> splitNumber = splitNumberOfSizeK(number,k);
            for(String s : splitNumber ){
                char[] charArray = s.toCharArray();
                int ans =0;
                for(char ch : charArray){
                    int b = ch;
                    ans+=b;
                }
                sb.append(ans);
            }
            number=sb.toString();
        }
        return number;

    }

    public static List<String> splitNumberOfSizeK(String number,int size){
        List<String> splitedList = new ArrayList<>();
        for(int i=0;i<number.length();i+=size){
            splitedList.add(number.substring(i,Math.min(number.length(),i+size)));
        }
        return splitedList;

    }
}
