package com.coding.codingninja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DuplicateInArray {

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test!=0){
            int input = Integer.parseInt(br.readLine());
            int[] in = new int[input];
            int[] out = new int[input];
            String[] inst = br.readLine().split("\\s+");
            for (int i = 0; i < inst.length; i++) {
                in[i] = Integer.parseInt(inst[i]);
            }

            for(int i = 0; i < in.length; i++){
                int value = out[in[i]];
                if(value!=0){
                    System.out.println(in[i]);
                    break;
                }else{
                    out[in[i]] = in[i];
                }
            }
            test--;
        }
    }
}
