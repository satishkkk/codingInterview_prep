package com.interviewBitScaler.heap;

public class MaxHeap1 {
    private int[] heap;
    private int maxSize;
    private int size;

    public MaxHeap1(int maxSize){
        this.maxSize = maxSize;
        this.size=0;
        heap = new int[this.maxSize+1];
        heap[0] = Integer.MAX_VALUE;
    }

    //return position of left child
    int getLeftChild(int pos){
        return 2*pos;
    }

    //return position of right child
    int getRightChild(int pos){
        return (2*pos)+1;
    }

    //return position of parent
    int getParent(int pos){
        return pos/2;
    }

    boolean isLeaf(int pos){
        if(pos > (size/2) && pos <=size){
            return true;
        }
        return false;
    }

    void swap(int fpos,int spos){
        int temp;
        temp = heap[spos];
        heap[spos] = heap[fpos];
        heap[fpos] = temp;
    }

    //Insert element in heap
    /*
    * 1. insert element at the end
    * 2. percolate up algorithem
    */
    public void insert(int element){
        if(size > maxSize) {throw new ArrayIndexOutOfBoundsException("Reached Max size heap ! ! !");}

        heap[size++] = element; // 1. insert element at the end
        //2. percolate up
        int current =size;
        while(heap[current] > heap[getParent(current)]){
            swap(current,getParent(current));
            current = getParent(current);
        }
    }

    //percolate down algorithm
    private void maxHeapify(int pos){
        //parent < pos then swap
        if(isLeaf(pos)) return;

        //if root is smaller then left and right child ?
        if(heap[pos] < heap[getLeftChild(pos)] || heap[pos] < heap[getRightChild(pos)]){

            if (heap[getLeftChild(pos)] > heap[getRightChild(pos)]) {
                swap(pos, getLeftChild(pos));
                maxHeapify(getLeftChild(pos));
            }
            else {
                swap(pos, getRightChild(pos));
                maxHeapify(getRightChild(pos));
            }
        }

    }

    //remove root node from the heap
    /*
    * 1. store root in variable
    * 2. move last element to the first element
    * 3. call heapify by percolate down . . .
    * */
    public int extractMax(){
        int popped = heap[1];
        heap[1] = heap[size--];
        maxHeapify(1);
        return popped;
    }

    public static void main(String[] args) {
        MaxHeap1 maxHeap1 = new MaxHeap1(15);
        maxHeap1.insert(5);

    }
}
