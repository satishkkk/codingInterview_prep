package com.interviewBitScaler.LectureX_Hashing;

import java.util.*;

public class A3_SortArrayInOrder {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(20, 14, 8, 18, 6  ));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList( 1, 16, 7, 6, 17, 3, 13, 8, 19, 20  ));
        solve(A,B);
    }


    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        Map<Integer,Integer> map = new TreeMap<>();

        for(Integer num : A){
            int count = map.getOrDefault(num,0);
            map.put(num,count+1);
        }

        ArrayList<Integer> out = new ArrayList<>();

        for(int i = 0 ;i<B.size();i++){
            int num =B.get(i);
            if(map.containsKey(num)){
                int frequency = map.get(num);
                for(int j=0;j<frequency;j++){
                    out.add(num);
                }
                map.put(num,-1);
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int frequency = entry.getValue();
            if(frequency != -1){
                for(int i=0;i<frequency;i++){
                    out.add(entry.getKey());
                }
            }
        }

        return out;
    }
}
