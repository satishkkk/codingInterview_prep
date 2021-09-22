package com.PatkarSir_core.Anatomy;

class Point {
    int x=5;
    int y=5;

    void move(int v1, int v2){
        x=v1;
        y=v2;
    }
    void print(){
        System.out.println("x="+x);
        System.out.println("y="+y);
    }

    Point(int v1, int v2){
        System.out.println("initilizer x="+x);
        System.out.println("initilizer y="+y);
        this.x = v1;
        this.y = v2;
    }
}

public class Point_class{
    public static void main(String[] args) {
        Point v1 = new Point(10,20);
        Point v2 = new Point(30,40);
        v1.print();
        v2.print();
        v1.move(1,2);
        v2.move(3,4);
        v1.print();
        v2.print();
    }
}
