package com.company.Leetcode.Feb;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
//
//public class SortElementsBasedOnFrequency {
//    private static int[] sortElementByFrequancy(int[] array) {
//
//        Map<Integer,Integer> frequencyMap = new TreeMap<>();
//        int count;
//        for(Integer num : array){
//            if(frequencyMap.containsKey(num)){
//                count = frequencyMap.get(num);
//                frequencyMap.replace(num,++count);
//            }else{
//                frequencyMap.put(num,1);
//            }
//        }
//        for(Map.Entry<Integer ,Integer> k : frequencyMap.entrySet()){
//            System.out.println("KEY : "+k.getKey()+" VALUE : "+k.getValue()+"\n");
//        }
//    return null;
//    }
//
//    public static void main (String args[]){
//
//        int[] array1 = new int[10];
//        int[] array= new int[]{2,2,3,5,4,3,5,3,6,6,6,6};
//
//        int[] sortedArray = sortElementByFrequancy(array);
//
////        System.out.println("Sorted arrays are :"+sortedArray.toString() );
//    }
//}
import java.util.*;

public class SortElementsBasedOnFrequency {

    // Driver Code
    public static void main(String[] args)
    {

        // Declare and Initialize an array
        int[] array = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> outputArray = new ArrayList<>();

        // Assign elements and their count in the list and map
        for (int current : array) {
            int count = map.getOrDefault(current, 0);
            map.put(current, count + 1);
            outputArray.add(current);
        }

        for(Integer a : outputArray){
            System.out.println(a);
        }

        // Compare the map by value
        SortComparator comp = new SortComparator(map);

        // Sort the map using Collections CLass
        Collections.sort(outputArray, comp);

        // Final Output
        for (Integer i : outputArray) {
            System.out.print(i + " ");
        }
    }
}

// Implement Comparator Interface to sort the values
class SortComparator implements Comparator<Integer> {
    private final Map<Integer, Integer> freqMap;

    // Assign the specified map
    SortComparator(Map<Integer, Integer> tFreqMap)
    {
        this.freqMap = tFreqMap;
    }

    // Compare the values
    @Override
    public int compare(Integer k1, Integer k2)
    {

        // Compare value by frequency
        int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));

        // Compare value if frequency is equal
        int valueCompare = k1.compareTo(k2);

        // If frequency is equal, then just compare by value, otherwise -
        // compare by the frequency.
        if (freqCompare == 0)
            return valueCompare;
        else
            return freqCompare;
    }
}
