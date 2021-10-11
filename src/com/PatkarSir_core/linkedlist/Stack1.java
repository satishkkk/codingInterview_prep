package com.PatkarSir_core.linkedlist;


public class Stack1 implements StackInterface{
    private Node head;

    public void push(int value){
//        ---
//            if(head == null){
//                head = new Node(value);
//            }else{
//                head = new Node(value,head);
//            }
//        ---
//             head = (head == null ) ? new Node(value) : new Node(value, head);

        head = new Node(value,head);
    }

    public int pop(){
        if(head != null){
            int value = head.getValue();
            head = head.getNextNode();
            System.out.println("Poped value : "+ value);
            return value;
        }
        return -1;
    }

    public void print(){
        System.out.println("Printing Stack");
        Node temp = head;

        while(temp!= null){
            System.out.println(temp.getValue());
            temp = temp.getNextNode();
        }
    }

}


class Node{
    private int value;
    private Node nextNode;

    Node(int value){
        this.value = value;
        this.nextNode = null;
    }

    Node(int value, Node nextNode){
        this.value = value;
        this.nextNode = nextNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}


