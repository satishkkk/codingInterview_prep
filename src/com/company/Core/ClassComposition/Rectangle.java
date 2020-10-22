package com.company.Core.ClassComposition;

public class Rectangle {
    private Point P1;
    private Point P2;
    private Point P3;
    private Point P4;

    private Segment s1;
    private Segment s2;
    private Segment s3;
    private Segment s4;

    Rectangle(){

    }

    public Point getP1() {
        return P1;
    }

    public void setP1(Point p1) {
        P1 = p1;
    }

    public Point getP2() {
        return P2;
    }

    public void setP2(Point p2) {
        P2 = p2;
    }

    public Point getP3() {
        return P3;
    }

    public void setP3(Point p3) {
        P3 = p3;
    }

    public Point getP4() {
        return P4;
    }

    public void setP4(Point p4) {
        P4 = p4;
    }

    public Segment getS1() {
        return s1;
    }

    public void setS1(Segment s1) {
        this.s1 = s1;
    }

    public Segment getS2() {
        return s2;
    }

    public void setS2(Segment s2) {
        this.s2 = s2;
    }

    public Segment getS3() {
        return s3;
    }

    public void setS3(Segment s3) {
        this.s3 = s3;
    }

    public Segment getS4() {
        return s4;
    }

    public void setS4(Segment s4) {
        this.s4 = s4;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "P1=" + P1 +
                ", P2=" + P2 +
                ", P3=" + P3 +
                ", P4=" + P4 +
                ", s1=" + s1 +
                ", s2=" + s2 +
                ", s3=" + s3 +
                ", s4=" + s4 +
                '}';
    }
}
