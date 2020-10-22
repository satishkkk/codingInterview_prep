package com.company.Core.thread;

public class Explore {

    public static void main(String[] args) {
        System.out.println("Welcome in Threading");

        Thread m = Thread.currentThread();
        m.setName("Manager");

        Thread t1 = new Thread("Satish");
        Thread t2 = new Thread("Gautam");

        System.out.println("The name of main thread: "+ m.getName() + " STATE : "+m.getState());
        System.out.println("The name of t1 thread:  "+ t1.getName() + " STATE : "+t1.getState());
        System.out.println("The name of t2 thread:  "+ t2.getName() + " STATE : "+t2.getState());

    }
}
