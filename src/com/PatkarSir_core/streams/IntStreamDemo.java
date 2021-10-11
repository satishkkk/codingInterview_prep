package com.PatkarSir_core.streams;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class IntStreamDemo {
    public static void main(String[] args) {
        OptionalInt max =IntStream.range(0,5).max();
        System.out.println(max.getAsInt());
    }
}
