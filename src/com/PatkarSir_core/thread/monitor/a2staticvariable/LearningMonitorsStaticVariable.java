package com.PatkarSir_core.thread.monitor.a2staticvariable;

/*
 * Illustrates that static variables are shared resources across threads and that they cause thread interference.
 * Observations : Local Variables are not Shared Resources.
 */
public class LearningMonitorsStaticVariable {
    public static void main(String[] args) {
        System.out.println("Start Race - Main thread");
        Car car = new Car();
        Bike bike = new Bike();
        car.setName("Car");
        bike.setName("Bike");
        //starting the threads .. .
        car.start();
        bike.start();

        try {
            car.join(); // block main thread , until car thread will complete - - - - - -
            bike.join(); // // block main thread , until bike thread will complete - - - - - -
        } catch (InterruptedException ex) {
            System.out.println("Join interrupted "+ ex);
        }
        System.out.println("End Race - Main thread");
    }
}



class TestBed
{
    static int lap = 0; //static variable which will share all the threads which will use the classs TestBed
    public void busyTracks()
    {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " Enters busyTracks");
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

