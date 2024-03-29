package com.PatkarSir_core.thread.monitor.a3synchronizedblock;

/*
* Illustrates that static variables are shared resources across threads and that they cause thread interference.
* The problem of this interference can be solved using a Monitor.
*
* Observation : Static Variables are Shared Resources. However, they may cause thread interference. The problem is solved using Monitors
* */
public class LearningMonitorSynchronized {
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
}

class TestBed
{
    static int lap = 0;
    public void busyTracks()
    {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " Enters busyTracks");

        synchronized(Regulator.lapMonitor) // synchronized block for static variable lap
        {
            for(lap=0;lap<5;lap++)
            {
                String str = String.format(
                        "%s in Lap %d %s",
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
}

class Car extends Thread
{
    @Override
    public void run()
    {
        System.out.println("Car Starts Journey");
        TestBed a = new TestBed();
        a.busyTracks();
        System.out.println("Car Ends Journey");
    }
}

class Bike extends Thread
{
    @Override
    public void run()
    {
        System.out.println("Bike Starts Journey");
        TestBed b = new TestBed();
        b.busyTracks();
        System.out.println("Bike Ends Journey");
    }
}
