package com.vc.easy;

import com.vc.hard.ListNode;

/*****
 *  Problem No: 203
 *  Category: Data Structures And Algorithms
 *  Tags: Linked List, Amazon, Facebook, Leetcode, Easy
 *  Title: Remove Linked List Elements
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Remove all elements from a linked list of integers that have value val. It is an easy problem that uses Linked List Data Structure to solve the problem.
 *  Description: Remove all elements from a linked list of integers that have value val.
 *  Input:  1->2->6->3->4->5->6, val = 6
 *  Output: 1->2->3->4->5
 *  Similar Question: Remove Element, Delete Node in a Linked List
 *****/

class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        final ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode current = head;
        ListNode prev = dummyNode;
        while(current != null) {
            if(current.val == val) {
                prev.next = current.next;
                current = prev.next;
            }
            else {
                prev = current;
                current = current.next;
            }
        }
        return dummyNode.next;
    }
}