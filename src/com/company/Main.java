package com.company;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args)  {

        Main m = new Main();
        m.start();
    }

    void start(){
        long[] a1= {3,4,5};
        long[] a2= fix(a1);
        System.out.println(a1[0] +a1[1]+a1[2]+ " ");
        System.out.println(a2[0] +a2[1]+a2[2]);
    }
    long[] fix(long[] a3){
        a3[1]=7;
        return a3;
    }

//    protected abstract void m1();
//    static final void m1();
//    transient private native void m1();
//    synchronized public final void  m1();
//    private native void ma();
//    static final synchronized protected void m1();

}

