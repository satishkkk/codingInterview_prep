package com.interviewBitScaler.linkedlist;

class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
}

public class Reversemton {
    public static void main(String[] args) {
        ListNode A = new ListNode(3);
        A = addAtStart(A,2);
        A = addAtStart(A,1);
        reverseBetween(A,1,2);

    }

    public static ListNode reverseBetween(ListNode A, int B, int C) {
        if (A==null) return null;
        if(C<=B) return A;

        ListNode prev = null;
        ListNode curr = A;

        int m = B;
        int n = C;

        while(m>1){
            System.out.println(m+" : m time");
            prev =curr;
            curr = curr.next;
            n--;m--;
        }

        ListNode tail = curr; // 2 -> tail
        ListNode tempHead = prev ; // 3->6

        prev =curr;
        curr = curr.next;
        n--;
        ListNode temp = null;
        while(n>0){
            System.out.println(n+" :n time");
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr= temp;
            n--;
        }

        if(tempHead!= null){
            tail.next = temp;
            tempHead.next = prev;
            return tempHead;
        }else{
            tail.next = curr;
            return tail.next;
        }
    }


//    public static ListNode reverseBetween(ListNode A, int count) {
//
//    }
    //addAtStart() will add a new node to the beginning of the list
    public static ListNode addAtStart(ListNode A,int data) {
        //Create a new node
        ListNode newNode = new ListNode(data);

        //Checks if the list is empty
        if(A == null) {
            //If list is empty, both head and tail will point to new node
            A = newNode;
            return A;
        }
        else {
            //Node temp will point to head
            ListNode temp = A;
            //newNode will become new head of the list
            A = newNode;
            //Node temp(previous head) will be added after new head
            A.next = temp;
        }
        return A;
    }
}
