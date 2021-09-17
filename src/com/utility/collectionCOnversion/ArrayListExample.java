package com.utility.collectionCOnversion;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);

        list.get(new Integer(0));
        printList(list);
        System.out.println("Print 1 st element " + list.get(8));

    }

    public static void printList(ArrayList<Integer> list){

        list.stream().forEach(System.out:: println);
    }


}
