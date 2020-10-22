package com.company.Core.thread.monitor;

public class LearningMonitors {

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



class TestBed
{
    public void busyTracks()
    {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " Enters busyTracks");
        int lap = 0;
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
