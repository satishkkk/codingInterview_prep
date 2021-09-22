package com.PatkarSir_core.thread.WhatsappGroupDesign_upgrade2;

import java.util.ArrayList;

class MessageQueue<T> {

    ArrayList<T> al = new ArrayList<>();

    // synchronized call
    synchronized public void enqueue(T i) {
        al.add(i);
        notify();
    }

    // synchronized call
    synchronized public T dequeue() {
        if (al.isEmpty()) {
            try {
                wait();
            }
            catch (Exception ex) {
                System.out.println("UNEXPECTED INTERUPTION");
            }
        }
        return al.remove(0);
    }

    synchronized public void print() {
        for (T i : al) {
            System.out.println("-->" + i);
        }
    }

    @Override
    synchronized public String toString() {
        String str = null;
        for (T s : al) {
            str += "::" + s;
        }
        return str;
    }
}