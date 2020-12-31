package com.company.Core.inheritance;

public class jpInterviewExplore {
    public static void main(String[] args) {
        A a = new B();
        a.display();
    }
}

class A{
    public void display(){
        System.out.println("Parent class A");
    }
}

class B extends A{
    @Override
    public void display(){
        System.out.println("Child class B");
    }
}

class C extends A{
    @Override
    public void display(){
        System.out.println("Child class C");
    }
}