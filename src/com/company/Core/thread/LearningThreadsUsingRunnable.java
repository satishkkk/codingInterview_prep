package com.company.Core.thread;

public class LearningThreadsUsingRunnable {

    public static void main(String[] args) {

        System.out.println("Welcome to threading");
        Work1 w1 = new Work1();
        Work2 w2 = new Work2();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);

        t1.start();
        t2.start();

        t1.setName("t1");
        t2.setName("t2");

        Thread t = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println(t.getName() + " says hello " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }
        }

    }
}



class Work1 implements Runnable {

    @Override

    public void run() {
        Thread t = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println(t.getName() + " says " + " hello " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }

    }
}



class Work2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println(t.getName() + " says " + " hello " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
