package com.company.Core.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StackImpl implements Stack {

    private int[] a;
    private int stackPointer;

    StackImpl(int size) {
        a = new int[size];
        stackPointer=size;
    }

    StackImpl() {
        this(10);
    }

    @Override
    public void push(int i) {
        if (stackPointer == 0) {
            System.out.println("OVERFLOW");
        } else {
            stackPointer--;
            a[stackPointer] = i;

        }

    }

    @Override
    public int pop() {
        if (stackPointer == a.length) {
            System.out.println("UNDERFLOW");
            return -1;
        } else {
            int temp = a[stackPointer];
            stackPointer++;
            return temp;
        }
    }

    @Override
    public void print() {
        System.out.println("CURRENT STACK STATUS : ");
        for (int i = stackPointer; i < a.length; i++) {
            System.out.println(" " + a[i]);
        }
    }

    @Override
    public int peek() {
        if(stackPointer!=a.length){
            return a[stackPointer];
        }else{
            return -1;
        }
    }
    void flush(){
        stackPointer=a.length;
    }

    void store(String s) throws IOException {
        PrintWriter fos = new PrintWriter(
                                     new BufferedWriter(
                                             new FileWriter(s)
                                     ), true
                                );

        for(int i=stackPointer ; i< a.length;i++){
            fos.println(" " +a[i]);
        }
    }

    
    //load from file

}
