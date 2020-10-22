package com.company.Core.stack;

public class Main {
    public static void main(String[] args) {

        Stack stack = new StackImpl(10);


        stack.push(10);
        stack.print();

        int peek = stack.peek();
        System.out.println(peek);

        stack.pop();
        stack.print();
    }
}
