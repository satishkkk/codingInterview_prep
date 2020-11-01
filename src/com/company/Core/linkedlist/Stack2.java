package com.company.Core.linkedlist;

import com.company.Core.stack.Stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Stack2 implements StackInterface,AnotherInterface{

    private int[] a;
    private int stackPointer;

    Stack2(int size) {
        a = new int[size];
        stackPointer=size;
    }

    Stack2() {
        this(10);
    }

    public void push(int i) {
        if (stackPointer == 0) {
            System.out.println("OVERFLOW");
        } else {
            stackPointer--;
            a[stackPointer] = i;

        }

    }

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

    public void print() {
        System.out.println("CURRENT STACK STATUS : ");
        for (int i = stackPointer; i < a.length; i++) {
            System.out.println(" " + a[i]);
        }
    }


    @Override
    public void extraMethod1() {
        System.out.println("HELLO from Extra metho1");
    }

    @Override
    public void extraMethod2() {
        System.out.println("HELLO from Extra metho2");
    }
}
