package com.coding.queue;

import java.util.ArrayList;
import java.util.List;

public class QueueImplementation {
    private List<Integer> data;
    private int p_start;

    public QueueImplementation(){
        data = new ArrayList<>();
        p_start=0;
    }

    public boolean enQueue(int x){
        data.add(x);
        return true;
    }

    public boolean deQueue(){
        if(isEmpty() == true){
            return false;
        }
        p_start++;
        return true;
    }

    public int front() {
        return data.get(p_start);
    }

    public boolean isEmpty(){
        return p_start >= data.size();
    }
    public static void main(String[] args) {
        QueueImplementation q = new QueueImplementation();
        q.enQueue(1);
        q.enQueue(2);

        if(q.isEmpty()==false){
            System.out.println(q.front());
        }

        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.front());
        }

        q.deQueue();
        if (q.isEmpty() == false) {
            System.out.println(q.front());
        }
    }

}
