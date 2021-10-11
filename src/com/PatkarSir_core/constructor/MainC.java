package com.PatkarSir_core.constructor;

public class MainC {
    public static void main(String[] args) {

        Point p1 = new Point(1,2);
        System.out.println(p1.toString());
        p1.Point();


    }
}

class Point{
    int x;
    int y;

    Point(int x,int y){
        this.x =x;
        this.y = y;
    }

    /*SAME AS CLASS NAME BUT WITH RETURN TYPE HANCE  IT ACT AS A METHOD AND NOT CONSTRUCVTOR*/
    void Point(){
        System.out.println("yeyeyey");
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


}
