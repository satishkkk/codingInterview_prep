package com.collections.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A1_ExploreArrayList_Basic {
    public static void main(String[] args) {
        System.out.println("WELCOME TO ARRAY LIST ");

        System.out.println("ARRAYLIST EX1: Add elements");
        ArrayList al = new ArrayList(); // default arraylist assume object as type
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        int sum = 0;
        for(Object a : al){
            sum = sum + (Integer)a;
            System.out.println("FIRST ITERATION : "+a);
        }
        System.out.println("SUM IS " + sum);


        ArrayList a2 = (ArrayList)al.clone(); //Clone the arrayList
        a2.add(5);
        for(Object a : a2){
            System.out.println("SECOND ITERATION : "+a);
        }

        for(Object a : al){
            sum = sum + (Integer)a;
        }
        System.out.println("SUM IS " + sum);

        Set s1= new HashSet();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        List a3 = new ArrayList(s1); //ArrayList Constructor which can accept collection as parameter
        a3.stream().forEach(s-> System.out.println(s+", "));

    }
}
