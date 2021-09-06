package com.interviewBitScaler.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KsortedArray {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode head =null;
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
//        PriortiyQueue<ListNode> minHeap = new PriortiyQueue<ListNode>( (ListNode l1,ListNode l2) -> l1.val - l2.val );
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((ListNode l1,ListNode l2) -> l1.val - l2.val  );

        for(ListNode node : a){
            minHeap.add(node);
        }

        ListNode temp =head;
        while(!minHeap.isEmpty()){
            ListNode out= minHeap.poll();
            temp.next = out;
            if(out.next!=null)
                minHeap.add(out.next);
        }
        return head;
    }
}

class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
 }