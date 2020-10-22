package com.company.Core.Anatomy;

public class Constructor {

    public static void main(String[] args) {
        Point1 v1 = new Point1(1,2);
        Point1 v2 = new Point1(11,12);
        v1.print();
        v2.print();


    }
}

class Point1 {
    int x=5;
    int y=5;

    {
        System.out.println("BEFORE INSTANCE BLOCK x="+x);
        System.out.println("BEFORE INSTANCE BLOCK y="+y);
        int x=6;
        int y=6;
        System.out.println("INSTANCE BLOCK x="+x);
        System.out.println("INSTANCE BLOCK y="+y);
    }

    void move(int v1, int v2){
        x=v1;
        y=v2;
    }
    void print(){
        System.out.println("x="+x);
        System.out.println("y="+y);
    }

    Point1(int v1, int v2){
        System.out.println("initilizer x="+x);
        System.out.println("initilizer y="+y);
        this.x = v1;
        this.y = v2;
        System.out.println("CONSTRUCTOR x="+x);
        System.out.println("CONSTRUCTOR y="+y);
    }
}
