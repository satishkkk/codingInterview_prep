package com.company.Core.serializationAndCloning;

import java.io.Serializable;

public class C1 implements Serializable {

    private int a;
    private int b;

    public C1() {
    }

    public C1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "C1{" + "a=" + a + ", b=" + b + '}';
    }

}
