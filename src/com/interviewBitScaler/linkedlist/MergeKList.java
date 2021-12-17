package com.interviewBitScaler.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class MergeKList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        List<ListNode> l1 = new LinkedList<>();
        l1.add(new ListNode(4));
        l1.add(new ListNode(6));
        l1.add(new ListNode(2));

        List<ListNode> l2 = new LinkedList<>();
        l2.add(new ListNode(1));
        l2.add(new ListNode(8));
        l2.add(new ListNode(3));
        ListNode[] arr = new ListNode[]{l1.get(0),l2.get(0)};
        mergeKLists(arr);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
            if(lists.length == 0){
                return null;
            }

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>
                    ( (o1,o2) -> {return o1.val-o2.val;} );

            for(int i=0;i<lists.length;i++){
                if(lists[i]!= null)  // for [[]]
                    pq.add(lists[i]);
            }

            while(!pq.isEmpty()){
                tail.next = pq.poll();
                tail = tail.next;
                if(tail.next != null)
                    pq.add(tail.next);
            }

            return dummy.next;
    }

}
