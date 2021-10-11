package com.PatkarSir_core.thread;

public class LearningThreadUsingExtends {
    public static void main(String[] args) {
        System.out.println("Welcome to threading");
        Work11 w1 = new Work11();
        Thread t1 = new Thread(w1);

        Work12 t2 = new Work12();
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


class Work11 implements Runnable {
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


class Work12 extends Thread {
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
