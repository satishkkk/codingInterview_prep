package com.PatkarSir_core.serializationAndCloning.ObjectGraph;

import java.io.Serializable;

public class C12 implements Serializable {

    int c;
    int d;

    public C12(int c, int d) {
        this.c = c;
        this.d = d;
    }

    public C12() {
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "C12{" + "c=" + c + ", d=" + d + '}';
    }

}