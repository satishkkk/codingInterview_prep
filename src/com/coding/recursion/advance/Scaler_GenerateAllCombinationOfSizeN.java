package com.coding.recursion.advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Scaler_GenerateAllCombinationOfSizeN {
    static int N = 3;
    static List<String> out = new ArrayList<String>();
    public static void main(String[] args) {
        int[] curr =new int[N];
        generate(curr,0);
        out.stream().forEach(System.out::println);
    }

    public static void generate(int[] curr,int index){
        if(index == N){
            //Base Case : Print combinations

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<N;i++){
                sb.append(curr[i]);
            }
            out.add(sb.toString());
            return;
        }
        curr[index]=1;
        generate(curr,index+1);

        curr[index]=2;
        generate(curr,index+1);
    }

}
