package com.PatkarSir_core.thread;

public class ThreadWorkAssignment {
    public static void main(String[] args) {
        System.out.println("ASSIGNING WORK USING LAMBDA : ");

        Thread m = Thread.currentThread();
        m.setName("Manager");
        for (int i = 0; i < 5; i++) {
            System.out.println("I am "+ m.getName()+ " iteration "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Thread t1 = new Thread(
                ()->{
                    Thread t = Thread.currentThread();
                    for (int i = 0; i < 5; i++) {
                        System.out.println("I am "+ t.getName()+ " iteration "+ i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        t1.setName("SATISH");

        Thread t2 = new Thread(
                ()->{
                    Thread t = Thread.currentThread();
                    for (int i = 0; i < 5; i++) {
                        System.out.println("I am "+ t.getName()+ " iteration "+ i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        );
        t2.setName("GAUTAM");

        t1.start();
        t2.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("I am "+ m.getName()+ " iteration "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
