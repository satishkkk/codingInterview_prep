package com.company.Core.ClassComposition;

public class Segment {
    Point p1;
    Point p2 ;

    Segment(){
        p1 = new Point();
        p2= new Point();
    }

    Segment(int x1,int y1, int x2, int y2){
        p1 = new Point(x1,y1);
        p2= new Point(x2,y2);
    }

    Segment(Point pt1 , Point pt2){
        this.p1=pt1;
        this.p2= pt2;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }



}
