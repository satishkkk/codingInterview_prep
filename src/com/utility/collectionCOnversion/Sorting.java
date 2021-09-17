package com.utility.collectionCOnversion;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Sorting {
    public static void main(String[] args) {
        int[] arr= new int[]{5,6,3,2,4,5,6,7,2,4};
        String[] str = new String[]{"zxbz","abdd","zxyz","abcd","zxaa"};

        String[] sortedString =
                        Arrays.stream(str)
                                .sorted((a,b)->a.substring(0,3).compareTo(b.substring(0,3)))
                                .toArray(String[] :: new);
//                               .collect(Collectors.toList());


        int[] k = Arrays.stream(arr)
                .boxed()
                .sorted((a,b)-> b-a)
                .mapToInt(Integer::intValue)
                .toArray();
//                .collect(Collectors.toList());

       Map<Integer,Integer> map = new TreeMap<>();

       for(int i=0;i<arr.length;i++){
           map.put(arr[i],map.getOrDefault(arr[i],0)+1);
       }

    }
}

