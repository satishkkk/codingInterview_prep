package com.interviewBitScaler.Two_Pointer;



import java.util.*;

public class P2_countPairWhoseDifferenceIsB {
    public static void main(String[] args) {

        int[] A = new int[]{ 8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};
        int B = 3;
        System.out.println(solve(A,B));
    }

    //O(N) and O(N)
    public static int solve(int[] A, int B) {

        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<A.length;i++){
            int count = map.getOrDefault(A[i],0);
            map.put(A[i],count+1);
        }


        int result=0;
        if(B==0){
            for(Map.Entry<Integer,Integer> e : map.entrySet()){
                if(e.getValue() >= 2){
                    result++;
                }
            }
        }else{
            for(Map.Entry<Integer,Integer> e : map.entrySet()){
                int x = e.getKey();
                int y = x-B;
                if(map.containsKey(y)){
                    result++;
                }
            }
        }
            return result;
    }
//    public static int solve(int[] A, int B) {
//
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for(int i=0;i<A.length;i++){
//            int count = map.getOrDefault(A[i],0);
//            map.put(A[i],count+1);
//        }
//
//        int result=0;
//        for(int i=0;i<A.length;i++){
//            int x = A[i];
//            int y = x - B;
//
//            if((y==x && map.get(x) > 1) || (map.containsKey(y))){
//                System.out.println("PAIR IS :"+ x + ", " + y);
//                result++;
//            }
//        }
//
//        System.out.println("result is :"+result);
//
//        int j = 0;
//        for(Map.Entry<Integer,Integer> e : map.entrySet()){
//            if(e.getValue() > 1)
//                j+= e.getValue()-1;
//        }
//        return result-j;
//    }
//
//    public static int solve(int[] A, int B) {
//
//        Map<Integer,Integer> map = new HashMap<>();
//        Map<Integer,Integer> freqmap = new HashMap<>();
//        for(int i=0;i<A.length;i++){
//            int count = freqmap.getOrDefault(A[i],0);
//            freqmap.put(A[i],count+1);
//        }
//
//        for(int i=0;i<A.length;i++){
//            int x = A[i];
//            int y = x - B;
//
//            if((freqmap.containsKey(y) && freqmap.get(y)>1) || (map.containsKey(y))){
//                System.out.println("PAIR IS :"+ x + ", " + y);
//                map.put(y,x);
//            }
//        }
//        return map.size();
//    }

}
