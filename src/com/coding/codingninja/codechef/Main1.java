package com.coding.codingninja.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        char[] ip = br.readLine().toCharArray();
        Set<Character> set = new LinkedHashSet<>();

        for(int i=0;i<ip.length;i++){
            set.add(ip[i]);
        }

        StringBuilder s= new StringBuilder();
        set.stream().forEach(c->s.append(c));
        System.out.println(s);

    }
}
