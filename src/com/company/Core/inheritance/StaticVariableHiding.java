package com.company.Core.inheritance;

public class StaticVariableHiding {

    public static void main(String[] args) {
        System.out.println("Welcome to object composition");

        Parent1.printX();
        Child1.printX();
        Child1.printY();

        Parent1.x=10;

        Parent1.printX();
        Child1.printX();
        Child1.printY();
    }
}

class Parent1 {
    static int x;
    static void printX(){
        System.out.println("Parents x is "+ x);
    }
}

class Child1 extends Parent1 {
//    static int x; //variable shadowing
    static int y;
    /* is it allowed ? yes its allowed . .  . .  . . but this is not overriding it called as method hiding */
    static void printX(){ // method hiding
        System.out.println("Child x is "+ x);
    }
    static void printY(){
        System.out.println("Chils Y is "+ y);
    }
}