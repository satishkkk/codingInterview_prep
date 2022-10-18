package com.coding.queue;

import java.util.ArrayList;
import java.util.List;

public class CircularQueue {
    List<Integer> queue;
    int front;
    int back;
    int size;

    public CircularQueue(int k) {
        queue = new ArrayList<>(k);
        front=-1;
        back=-1;
        size=k;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            front=0;
        }
        back = (back+1)%size;
        queue.add(back,value);
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(front==back){ /* VERY IMPORTANT CONDITION*/
            front=-1;
            back=-1;
            return true;
        }
        front = (front+1)% size;
        return true;
    }

    public int Front() {
        if (isFull() == true) {
            return -1;
        }
        return queue.get(front);
    }

    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return queue.get(back);
    }

    public boolean isEmpty() {
        return front==-1;
    }

    public boolean isFull() {
        return (back+1)%size == front;
    }

    public static void main(String[] args) {
        CircularQueue obj = new CircularQueue(3);
        boolean param_1 = obj.enQueue(1);
        boolean param_2 = obj.enQueue(2);
        boolean param_3 = obj.enQueue(3);
        boolean param_4 = obj.enQueue(4);
        int param_6 = obj.Rear();
        boolean param_8 = obj.isFull();
        obj.deQueue();
        obj.enQueue(4);
        obj.Rear();

    }

}
