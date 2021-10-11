//package com.Core.thread.monitor.a9waitandnotify;
//public class LearnWaitandNotify {
//    public static void main(String[] args) {
//        System.out.println("Start Race");
//
//        Car car = new Car();
//        Bike bike = new Bike();
//        car.setName("Car");
//        bike.setName("Bike");
//        car.start();
//        bike.start();
//        try {
//            car.join();
//            bike.join();
//        } catch (InterruptedException ex) {
//            System.out.println("Join interrupted " + ex);
//        }
//        System.out.println("End Race");
//    }
//
//}
//
//class Regulator {
//
//    static TestBed a = new TestBed();
//    static TestBed b = new TestBed();
//    static Car car = new Car();
//    static Bike bike = new Bike();
//}
//
//class TestBed {
//
//    synchronized public void busyTracks() {
//        int lap = 0;
//        Thread t = Thread.currentThread();
//        System.out.println(t.getName() + " Enters busyTracks");
//        for (lap = 0; lap < 5; lap++) {
//            String str = String.format(
//                    "%s in Lap %d %s of busyTracks",
//                    t.getName(),
//                    lap,
//                    t.getName().equals("Car")
//                            ? "brrrrooms" : "vrrrrooms"
//            );
//            System.out.println(str);
//            try {
//                System.out.println("The state of car is " +
//                        car.getState());
//                System.out.println("The state of bike is " +
//                        bike.getState());
//                if (lap==2 && t.getName().equals("Car")) {
//                    System.out.println("" + t.getName()
//                            + " goes in wait state in busyTracks");
//                    wait();
//
//                } else {
//                    if(car.getState() == Thread.State.WAITING){
//                        System.out.println("" + t.getName()
//                                + " notifies the monitor in busyTracks");
//                        notify();
//                    }
//                    Thread.sleep(1000);
//                }
//            } catch (InterruptedException e) {
//                System.out.println("Thread Interrupted");
//            }
//        }
//        System.out.println(t.getName() + " Leaves busyTracks");
//
//    }
//
//    synchronized public void busyLanes() {
//        int lap ;
//        Thread t = Thread.currentThread();
//        System.out.println(t.getName() + " Enters busyLanes");
//        for (lap = 0; lap < 5; lap++) {
//            String str = String.format(
//                    "%s in Lap %d %s of busyLanes",
//                    t.getName(),
//                    lap,
//                    t.getName().equals("Car")
//                            ? "brrrrooms" : "vrrrrooms"
//            );
//            System.out.println(str);
//            try {
//                System.out.println("The state of car is " +
//                        car.getState());
//                System.out.println("The state of bike is " +
//                        bike.getState());
//                if(car.getState() == Thread.State.WAITING){
//                    System.out.println("" + t.getName()
//                            + " notifies the monitor in busyLanes");
//                    notify();
//                }
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Thread Interrupted");
//            }
//        }
//
//        System.out.println(t.getName() + " Leaves busyLanes");
//
//    }
//
//}
//
//class Car extends Thread {
//
//    @Override
//    public void run() {
//        System.out.println("Car Starts Journey");
//        a.busyTracks();
//        a.busyLanes();
//        System.out.println("Car Ends Journey");
//    }
//}
//
//class Bike extends Thread {
//
//    @Override
//    public void run() {
//        System.out.println("Bike Starts Journey");
//        a.busyLanes();
//        a.busyTracks();
//        System.out.println("Bike Ends Journey");
//    }
//}
