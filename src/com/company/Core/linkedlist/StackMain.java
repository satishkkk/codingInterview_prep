package com.company.Core.linkedlist;


public class StackMain {

    public static void main(String[] args) {
        StackInterface stack1 = new Stack1();
        StackInterface stack2 = new Stack2();

        client1(stack1);
        client2(stack2);

    }


    static void client1(StackInterface stack1) {
        stack1.push(10);
        stack1.push(30);
        stack1.push(20);
        stack1.pop();
    }


    static void client2(StackInterface stack2) {
        stack2.push(10);
        stack2.push(30);
        stack2.push(20);

    }
}