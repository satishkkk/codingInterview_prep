package com.company.Core.thread.monitor.a5overlocking;
/*
*
* Illustrate how static shared monitor is not an ideal solution to manage thread interference due to instance variables.
*Solution : The solution of one monitor doesn't work well with instance well as it blocks thread even when the given variable is not a shared resource.
* */
public class LearningMonitorToControlInstanceVariable {
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
            System.out.println("Join interrupted "+ ex);
        }
        System.out.println("End Race");
    }

}

class Regulator{
    static Object lapMonitor = new Object();
    static RacingCircuit a = new RacingCircuit();
    static RacingCircuit b = new RacingCircuit();
}

class RacingCircuit
{
    int lap = 0;
    public void busyTracks()
    {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " Enters busyTracks");
        synchronized(Regulator.lapMonitor)
        {
            for(lap=0;lap<5;lap++)
            {
                String str = String.format(
                        "%s in Lap %d %s from busyTracks",
                        t.getName(),
                        lap,
                        t.getName().equals("Car")?"brrrrooms":"vrrrrooms"
                );
                System.out.println(str);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                    System.out.println("Thread interrupted");
                }
            }
        }
        System.out.println(t.getName() + " Leaves busyTracks");
    }

    public void busyLanes()
    {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " Enters busyLanes");
        synchronized(Regulator.lapMonitor)
        {
            for(lap=0;lap<5;lap++)
            {
                String str = String.format(
                        "%s in Lap %d %s from busyLanes",
                        t.getName(),
                        lap,
                        t.getName().equals("Car")?"brrrrooms":"vrrrrooms"
                );
                System.out.println(str);
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e)
                {
                    System.out.println("Thread interrupted");
                }
            }
        }
        System.out.println(t.getName() + " Leaves busyLanes");
    }
}

class Car extends Thread
{
    @Override
    public void run()
    {
        System.out.println("Car Starts Journey");
        Regulator.a.busyTracks();
        Regulator.a.busyLanes();
        Regulator.a.busyLanes();
        System.out.println("Car Ends Journey");
    }
}

class Bike extends Thread
{
    @Override
    public void run()
    {
        System.out.println("Bike Starts Journey");
        Regulator.b.busyLanes();
        Regulator.b.busyTracks();
        Regulator.b.busyLanes();
        System.out.println("Bike Ends Journey");
    }
}