package com.coding.sorting.application;

import java.util.*;

public class SortElementByFrequency {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 2, 8, 5, 6, 8, 8};
        sortArrayElementsByFrequency(arr);
    }

    private static void sortArrayElementsByFrequency(int[] inputArray)
    {
        Map<Integer, Integer> elementCountMap = new LinkedHashMap<>();

        for (int i = 0; i < inputArray.length; i++)
        {
            if (elementCountMap.containsKey(inputArray[i]))
            {
                //If element is present in elementCountMap, increment its value by 1
                elementCountMap.put(inputArray[i], elementCountMap.get(inputArray[i])+1);
            }
            else
            {
                //If element is not present, insert this element with 1 as its value
                elementCountMap.put(inputArray[i], 1);
            }
        }

        //Create an ArrayList to hold sorted elements

        ArrayList<Integer> sortedElements = new ArrayList<>();

        //Java 8 code to sort elementCountMap by values in reverse order
        //and put keys into sortedElements list

        elementCountMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
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
