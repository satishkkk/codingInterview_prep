package com.company.Goldman;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExaples {
    public static void main(String[] args) {
        int[] a=new int[]{5,5,5,5};
        int[] b=new int[]{4,4,6,4};

        Set<List<Integer>> set = new HashSet<>();

        for(int i=0;i<a.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(a[i]);
            list.add(b[i]);
            set.add(list);
        }


    }
}
