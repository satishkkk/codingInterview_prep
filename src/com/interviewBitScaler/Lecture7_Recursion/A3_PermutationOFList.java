package com.interviewBitScaler.Lecture7_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A3_PermutationOFList {
    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1));
//        ArrayList<ArrayList<Integer>> out = permute(a);
//        out.stream().forEach(p-> p.stream().forEach(System.out::println));
        ArrayList<Integer> z = new ArrayList<>();
        permute1(a,z);
        System.out.println(mr.size());
    }


    public static ArrayList<ArrayList<Integer>> permute(List<Integer> A) {
        if(A.size()==1){
            ArrayList<Integer> one = new ArrayList<>(Arrays.asList());
            one.add(0,A.get(0));
            ArrayList<ArrayList<Integer>> out = new ArrayList<>();
            out.add(one);
            return out;
        }

        int firstInt = A.get(0);
        List<Integer> subList= A.subList(1,A.size());
        ArrayList<ArrayList<Integer>> rr = permute( subList);

        ArrayList<ArrayList<Integer>> mr = new ArrayList<>();
        for(ArrayList<Integer> s : rr){
            for(int i=0;i<=s.size();i++){
                ArrayList<Integer> temp = new ArrayList<>(s);
                temp.add(i,firstInt);
                mr.add(temp);
            }
        }
        return mr;
    }

    static ArrayList<ArrayList<Integer>> mr = new ArrayList<>();
    public static void permute1(ArrayList<Integer> in, ArrayList<Integer> out) {

        if(in.size()==1){
            ArrayList<Integer> s= new ArrayList<>(out);
            s.add(in.get(0));
            mr.add(s);
            return;
        }

        for(int i=0 ;i< in.size();i++){
            ArrayList<Integer> a =new ArrayList<>(in);
            ArrayList<Integer> b =new ArrayList<>(out);
            b.add(in.get(i));
            a.remove(i);
            permute1(a,b);
        }

    }

}

