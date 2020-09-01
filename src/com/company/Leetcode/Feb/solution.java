package com.company.Leetcode.Feb;

import java.util.*;

public class solution {

//
//        public String getFileName(String fileName) {
//            if(fileName.contains("-")){
//                return fileName.substring(fileName.indexOf('-')+1);
////                return fileName.split("_")[0];
//            }else{
//                return "SATISH";
//            }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }

        public static void main(String args[]) {
            solution s = new solution();
//            String a = s.getFileName("TFU-FRODOCFDabc.pdf");

            new ArrayList<>(Arrays.asList("a"));
            int[] arr = {4,1,2,1,2};
//            int n=arr.length;
            int a = s.singleNumber(arr);
                        System.out.println(a);
        }

}
