package com.utility.collectionCOnversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListToArray {
    public static void main(String[] args) {
        List<Integer> IntegerList = new ArrayList<>(Arrays.asList(1,2,3,4));
        IntegerList.add(null);

//        int[] a = convertListToInt(IntegerList);
//        Arrays.stream(a).forEach(System.out::println);

        int[] b = convertListToIntJava8(IntegerList);
        Arrays.stream(b).forEach(System.out::println);
    }



    //Integer.intValue()
    public static int[] convertListToInt(List<Integer> IntegerList){
        int[] a = new int[IntegerList.size()];

        for(int i=0;i<IntegerList.size();i++){
            a[i] = IntegerList.get(i).intValue();
        }
        return a;
    }

    //JAVA 8
    //
    public static int[] convertListToIntJava8(List<Integer> IntegerList){
        int[] a = IntegerList.stream()
//                .mapToInt(i -> i==null ? 0 : i) // to handle null
                .mapToInt(Integer::intValue)
                .toArray();

        return a;
    }

    // to convert string to integer -> Integer.parseInt("24")
}
