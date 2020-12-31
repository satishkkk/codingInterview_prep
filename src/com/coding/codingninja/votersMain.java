package com.coding.codingninja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/*
* 3 2 3
5
6
7
5
6
5
6
7
* */
public class votersMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split("\\s+");
        int N1 =Integer.parseInt(in[0]);
        int N2 =Integer.parseInt(in[1]);
        int N3 =Integer.parseInt(in[2]);

        int total = N1+N2+N3;

        int[] arr= new int[total];

        for(int i=0;i<total;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        ArrayList<Integer> voterslist=new ArrayList<>();

        for(int i=0;i<total;){
            int count=0;
            int j=i;
            while(j<total && (arr[j]==arr[i])){
                count++;
                j++;
            }
           if(count>=2){
                voterslist.add(arr[i]);
           }
            i=j;
        }
        System.out.println(voterslist.size());
        voterslist.forEach(System.out::println);
    }
}
