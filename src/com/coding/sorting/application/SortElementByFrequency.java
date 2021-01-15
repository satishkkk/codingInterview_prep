package com.coding.sorting.application;

import java.util.*;
//java 8 sort article
//https://www.baeldung.com/java-8-sort-lambda

public class SortElementByFrequency {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 2, 8, 5, 6, 8, 8};
        sortArrayElementsByFrequency(arr);
    }

    private static void sortArrayElementsByFrequency(int[] inputArray)
    {
        //Create an ArrayList to hold sorted elements
        ArrayList<Integer> sortedElements = new ArrayList<>();

        Map<Integer, Integer> elementCountMap = new LinkedHashMap<>();
        for (int i = 0; i < inputArray.length; i++)
        {
            int count = elementCountMap.getOrDefault(inputArray[i], 0);
            elementCountMap.put(inputArray[i], count + 1);
        }

        //Java 8 code to sort elementCountMap by values in reverse order
        //and put keys into sortedElements list

        Comparator<Map.Entry<Integer,Integer>> comparator = (e1,e2)-> e2.getValue().compareTo(e1.getValue());

        elementCountMap.entrySet()
                .stream()
//                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .sorted(comparator)
                .forEach(entry -> {
                    for(int i = 1; i <= entry.getValue(); i++)
                        sortedElements.add(entry.getKey());
                });

        //Printing sorted array elements in descending order of their frequency

        System.out.println("Input Array :"+Arrays.toString(inputArray));

        System.out.println("Sorted Array Elements In Descending Order Of their Frequency :");

        System.out.println(sortedElements);
    }
}

