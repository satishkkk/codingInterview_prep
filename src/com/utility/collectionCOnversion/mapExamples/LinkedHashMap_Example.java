package com.utility.collectionCOnversion.mapExamples;


import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LinkedHashMap_Example {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,2,3,5,6,8};
        Set<Integer> set = new LinkedHashSet<>();

        for(int i: arr){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        System.out.println(set.stream().findFirst().get());

    }
}
