package com.interviewBitScaler.LectureX_Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMaptest {
    public static void main(String[] args) {

        Map<ArrayList<Integer>, Integer> mp = new HashMap<ArrayList<Integer>, Integer>();

        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        tmp.add(2);



        mp.put(tmp,1);

        if(mp.get(tmp)!= null){
            System.out.println("HASH MAP WORKS");
        }else{
            System.out.println("NOT WORK");
        }
    }
}
