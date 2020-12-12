package com.coding.codingninja;

import java.util.*;

/* practice java8 and set
* and conversion of datastructure
* */

public class RemoveDuplicates {
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            int[] input = new int[n];
            for(int i = 0; i < n; i++) {
               input[i] = s.nextInt();
            }

            Integer[] a = removeDuplicateElement(input);
            Arrays.stream(a).forEach(System.out::println);

            System.out.println("Sorting the unique values");
//            sortArray(Arrays.stream(a).mapToInt(i->i).toArray()); //convert Integer[] array to int[] array
            sortArray(Arrays.asList(a));
        }
        catch(Exception e){}
    }

    public static Integer[] removeDuplicateElement(int[] arr){
        Set<Integer> s = new HashSet<>();
        Arrays.stream(arr).forEach(s::add);
//        return s.toArray();  //return array of object
        return s.stream().toArray(Integer[] :: new);
    }

    public static void sortArray(List<Integer> arr){
//        Collections.sort(arr);
        arr.sort(Integer::compareTo);
        arr.stream().forEach(System.out::println);
    }

}
