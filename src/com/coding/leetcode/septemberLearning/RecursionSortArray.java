package com.coding.leetcode.septemberLearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* ADITYA VERMA METHOD
* TODO:
* B -> Base Condition
* H -> Hypothesis
* I -> Inductions
*/
public class RecursionSortArray {

    public static void main(String[] args) {
        Integer[] array = {5,0,4,3};
        List<Integer> a = new ArrayList<>(Arrays.asList(array));
        sort(a);
        System.out.println(Arrays.toString(a.toArray()));

    }

    static void sort(List<Integer> ip){

        if(ip.size()==1)
            return;

        int var = ip.get(ip.size()-1);
        ip.remove(ip.size()-1);

        sort(ip);

        insert(ip,var);
    }

    static void insert(List<Integer> in , int element){

        if(in.size()==0 || element>=in.get(in.size()-1)){
            in.add(element);
            return;
        }

        int val = in.get(in.size()-1);
        in.remove(in.size()-1);

        insert(in,element);

        in.add(val);
        return;
    }
}
