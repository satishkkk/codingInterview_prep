package com.coding.recursion.Lecture7_Recursion.RecursionGet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A3_PrintAllSubsequence {


    static ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));

    public static void main(String[] args) {
        System.out.println("------------------------ sub sequence of string ------------------------------");
        subSequence("abc","");

        System.out.println("------------------------1 st way ------------------------------");
        ArrayList<Integer> b = new ArrayList<>();
        subSequenceOfList(0,list.size(),b);
        finalOut.stream().forEach(System.out:: println);

        System.out.println("------------------------2 nd way ------------------------------");
        ArrayList<ArrayList<Integer>> a = getSubSequenceOfList(list);
        a.stream().forEach(System.out:: println);
    }

    //print
    public static void subSequence(String s,String out){
        if(s.length()==0){
            System.out.println(out);
            return;
        }

        char ch = s.charAt(0);
        String ros = s.substring(1);

        subSequence(ros,out); // do not include
        subSequence(ros,out+ch); // please include the character
    }

    //GET
    public static ArrayList<ArrayList<Integer>> getSubSequenceOfList(List<Integer> in){
        if(in.size()==0 ){
            ArrayList<ArrayList<Integer>> b = new ArrayList<>();
            b.add(new ArrayList<>());
            return b;
        }

        int c = in.get(0); // get first character
        ArrayList<ArrayList<Integer>> recursiveResult=getSubSequenceOfList(in.subList(1,in.size())); // recursive call with smaller input
        ArrayList<ArrayList<Integer>> myResult = new ArrayList<>(recursiveResult); // initalize with recursive result

        for(ArrayList<Integer> a : recursiveResult){
            ArrayList<Integer> temp = new ArrayList<>(a); // create new array list very inportan . . . .
            temp.add(0,c); // add first character in each of the element
            myResult.add(temp);
        }
        return myResult;
    }

    static ArrayList<ArrayList<Integer>> finalOut = new ArrayList<>();

    public static void subSequenceOfList( int sIdx, int eIdx, ArrayList<Integer> out){
        if( sIdx == eIdx ){//base condition
            finalOut.add(new ArrayList<>(out));
            return;
        }

        subSequenceOfList(sIdx+1,eIdx,out); // do not consider that character
        out.add(list.get(sIdx));
        subSequenceOfList(sIdx+1,eIdx,out);//  consider that character
        out.remove(out.size()-1);
    }

}
