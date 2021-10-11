package com.PatkarSir_core.thread.monitor.a1localvariable;

public class LearningMonitorsLocalVariable {

    /*
    * DIFFERENCE BETWEEN START AND JOIN . . . . .
    * Illustrates that local variables are not shared resources across threads and that they don’t cause thread interference.
    * Observations : Local Variables are not Shared Resources.
    */

    public static void main(String[] args) {
        System.out.println("Start Race - Main Thread");

        Car car = new Car();
        Bike bike = new Bike();
        car.setName("Car");
        bike.setName("Bike");

        car.start(); //start car thread
        bike.start(); //start bike thread

        try {
            car.join(); // block main thread , until car thread will complete - - - - - -
            bike.join(); // // block main thread , until bike thread will complete - - - - - -
        } catch (InterruptedException ex) {
            System.out.println("Join interrupted "+ ex);
        }

        System.out.println("End Race - Main Thread");
    }
}

class TestBed
{
    public void busyTracks()
    {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " Enters busyTracks");

        int lap = 0; // local variable which is different for all the threads
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
