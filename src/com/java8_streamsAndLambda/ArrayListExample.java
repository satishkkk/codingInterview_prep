package com.java8_streamsAndLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
//        list.add(new Pair(1,2));
//        list.add(new Pair(3,4));
//        list.add(new Pair(2,6));

//        Collections.sort(list,(p1,p2) -> p1.x -p2.x);
        Collections.sort(list);
        System.out.println("Test");
    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
