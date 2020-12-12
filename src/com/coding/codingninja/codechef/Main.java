package com.coding.codingninja.codechef;

import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**/
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("\\s+");
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        boolean isUnique = true;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > 1 ){
                System.out.println(entry.getKey()+" "+entry.getValue());
                isUnique=false;
            }
        }
        if(isUnique){
            System.out.println(-1);
        }



    }
}
