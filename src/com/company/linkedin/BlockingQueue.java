package com.company.linkedin;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<Integer> queue;
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized(queue){

            while(queue.size() >= capacity){
                queue.wait();
            }
            queue.add(element);
            queue.notify();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized(queue){

            while(queue.size() <= 0){
                queue.wait();
            }
            int element = queue.poll();
            queue.notify();
            return element;
        }
    }

    public int size() {
        return queue.size();
    }

}
