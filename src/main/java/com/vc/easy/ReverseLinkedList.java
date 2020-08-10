package com.vc.easy;

import com.vc.hard.ListNode;

/*****
 *  Problem No: 206
 *  Category: Data Structures And Algorithms
 *  Tags: Linked List, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Reverse Linked List
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Reverse a singly linked list. It is an easy problem that uses Linked List Data Structure to solve the problem.
 *  Description: Reverse a singly linked list.
 *  Input: 1->2->3->4->5->NULL
 *  Output: 5->4->3->2->1->NULL
 *  Similar Question: Reverse Linked List II, Palindrome Linked List, Binary Tree Upside Down
 *****/

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        final ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        final ListNode prev = dummyNode;
        final ListNode current = prev.next;
        ListNode next = current.next;
        while(next != null) {
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;

            /**
                 p     c    n
                 d =>  1 -> 2 -> 3 -> 4 -> 5

                 p     n    c
                 d =>  2 -> 1 -> 3 -> 4 -> 5

                 p          c    n
                 d =>  2 -> 1 -> 3 -> 4 -> 5
             */
            next = current.next;
        }
        return dummyNode.next;
    }
}
