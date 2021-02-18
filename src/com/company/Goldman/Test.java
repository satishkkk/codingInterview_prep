package com.company.Goldman;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        int[] a = new int[]{-5,1,4,-7,10,-7,0,7,3,0,-2,-5,-3,-6,4,-7,-8,0,4,9,4,1,-8,-6,-6,0,-9,5,3,-9,-5,-9,6,3,8,-10,1,-2,2,1,-9,2,-3,9,9,-10,0,-9,-2,7,0,-4,-3,1,6,-3};
//        int[] a = new int[]{-5,1,4,-7,10,-7};
        int target = -1;
        int[] out= twoSum(a,target);
        System.out.println("OUR");
        System.out.println(out[0]);
        System.out.println(out[1]);
    }

    public static int[] twoSum(final int[] A, int B){
        List<Pair> pairs = new ArrayList<>();
        int n = A.length;
        int[] out =new int[2];
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        for(int i=0;i<n;i++){
//
//            map.put(A[i],i);
//        }
//        for(int i=0;i<n;i++){
//            int diff = B-A[i];
//            if(map.containsKey(diff)){
//                int j= map.get(diff);
//                if(j>i){
//                    pairs.add(new Pair(i,j));
//                }
//            }
//        }

        for(int i=0;i<n-1;i++){
            int diff = B-A[i];
            for (int j=i+1;j<n;j++){
                if(diff == A[j]){
                    pairs.add(new Pair(i,j));
                }
            }
        }

        pairs.forEach(p-> System.out.println(p.index1+" , "+p.index2));
        if(pairs.size()!=0){
            pairs.sort( new pairComparator());
            out[0]= pairs.get(0).getIndex1()+1;
            out[1]= pairs.get(0).getIndex2()+1;
            return out;
        }
        return new int[0];
    }
}

class Pair{

    int index1;
    int index2;

    Pair(int index1,int index2){
        this.index1=index1;
        this.index2=index2;
    }

    public int getIndex1() {
        return index1;
    }

    public void setIndex1(int index1) {
        this.index1 = index1;
    }

    public int getIndex2() {
        return index2;
    }

    public void setIndex2(int index2) {
        this.index2 = index2;
    }
}
class pairComparator implements Comparator<Pair>{

    @Override
    public int compare(Pair p1, Pair p2) {
        int c = p1.getIndex2() - p2.getIndex2();

        if(c==0){
            return p1.getIndex1() - p2.getIndex1();
        }
        return c;
    }
}

