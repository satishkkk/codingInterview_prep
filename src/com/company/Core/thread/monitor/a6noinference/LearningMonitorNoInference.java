package com.company.Core.thread.monitor.a6noinference;

/*
*Illustrate how instance variables cause and don’t cause thread interference.
*
*OBERVATION :
* The solution shows two threads running initially without interfering with each other.
* Here the instance variable lap used for iteration is not a shared variable as both the threads use different objects of TestBed.
 * However when both the threads use the same instance of TestBed , they start interfering with each other. This is because of lap being a shared variable.
*
* */
public class LearningMonitorNoInference {

    public static void main(String[] args) {
        System.out.println("Start Race");
        Car car = new Car();
        Bike bike = new Bike();
        car.setName("Car");
        bike.setName("Bike");
        car.start();
        bike.start();
        try {
            car.join();
            bike.join();
        } catch (InterruptedException ex) {
            System.out.println("Join interrupted " + ex);
        }
        System.out.println("End Race");
    }
}

class Regulator {
    static TestBed a = new TestBed();
    static TestBed b = new TestBed();
}

class TestBed {

    int lap = 0;

    public void busyTracks() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " Enters busyTracks");
        for (lap = 0; lap < 5; lap++) {
            String str = String.format(
                    "%s in Lap %d %s of busyTracks",
                    t.getName(),
                    lap,
                    t.getName().equals("Car") ? "brrrrooms" : "vrrrrooms"
            );
            System.out.println(str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        System.out.println(t.getName() + " Leaves busyTracks");
    }

    public void busyLanes() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " Enters busyLanes");
        for (lap = 0; lap < 5; lap++) {
            String str = String.format(
                    "%s in Lap %d %s of busyLanes",
                    t.getName(),
                    lap,
                    t.getName().equals("Car") ? "brrrrooms" : "vrrrrooms"
            );
            System.out.println(str);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        System.out.println(t.getName() + " Leaves busyLanes");
    }
}

class Car extends Thread {

    @Override
    public void run() {
        System.out.println("Car Starts Journey");
        Regulator.a.busyTracks();
        Regulator.a.busyLanes();
        Regulator.b.busyLanes();
        Regulator.a.busyTracks();
        System.out.println("Car Ends Journey");
    }
}

class Bike extends Thread {

    @Override
    public void run() {
        System.out.println("Bike Starts Journey");
        Regulator.b.busyLanes();
        Regulator.b.busyTracks();
        Regulator.b.busyLanes();
        Regulator.a.busyTracks();
        System.out.println("Bike Ends Journey");
    }
}
