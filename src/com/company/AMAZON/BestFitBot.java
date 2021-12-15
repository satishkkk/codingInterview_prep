package com.company.AMAZON;

import java.util.Map;

public class BestFitBot {
    public static void main(String[] args) {


    }

    public static int getIdForBox(int packageSize, Map<Integer,Integer> map){
        int id =-1;
        int minValue = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> rack : map.entrySet()){
            if(rack.getValue() >= packageSize && minValue>rack.getValue()  ){
                minValue = rack.getValue();
                id = rack.getKey();
            }
        }
        return id;
    }
}
