package com.PatkarSir_core.serializationAndCloning.ObjectGraph;

import java.io.Serializable;

public class C11 implements Serializable {

    private int a;
    private int b;
    private C12 obj12;

    public C11(int a, int b, C12 obj12) {
        this.a = a;
        this.b = b;
        this.obj12 = obj12;
    }

    public C11() {
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

    public C12 getObj2() {
        return obj12;
    }

    public void setObj2(C12 obj12) {
        this.obj12 = obj12;
    }

    @Override
    public String toString() {
        return "C1{" + "a=" + a + ", b=" + b + ", obj2=" + obj12 + '}';
    }
}
