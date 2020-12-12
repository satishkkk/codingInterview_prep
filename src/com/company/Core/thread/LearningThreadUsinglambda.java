package com.company.Core.thread;

public class LearningThreadUsinglambda {

    public static void main(String[] args) {
        System.out.println("Welcome to threading");

        Thread t1 = new Thread(
                () -> {
                    Thread t = Thread.currentThread();
                    for (int i = 0; i < 5; i++) {
                        System.out.println(
                                t.getName() +
                                        " says " + " hello "
                                        + i
                        );

                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                    }
                });
        
        t1.start();

        (new Thread() {
            @Override
            public void run() {
                Thread t = Thread.currentThread();
                for (int i = 0; i < 5; i++) {
                    System.out.println(
                            t.getName() +
                                    " says " + " hello "
                                    + i
                    );
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
            }
        }).start();

        Thread t = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println(
                    t.getName() +
                            " says hello "
                            + i
            );

            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }
        }
    }
}
