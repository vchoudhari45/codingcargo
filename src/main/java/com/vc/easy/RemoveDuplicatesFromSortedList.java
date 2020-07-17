package com.vc.easy;

import com.vc.hard.ListNode;

/*****
 *  Problem No: 83
 *  Category: Data Structures And Algorithms
 *  Tags: Linked List, Microsoft, Leetcode, Easy
 *  Title: Remove Duplicates from Sorted List
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a sorted linked list, delete all duplicates such that each element appear only once. It is an easy problem that uses Linked List Data Structure to solve the problem.
 *  Description: Given a sorted linked list, delete all duplicates such that each element appear only once.
 *  Input: 1->1->2
 *  Output: 1->2
 *  Input: 1->1->2->3->3
 *  Output: 1->2->3
 *  Similar Question: Remove Duplicates from Sorted List II
 *****/

class RemoveDuplicatesFromSortedList {
    /**
     *  Algorithm:
     *
     *  Current Element is represented by C
     *  Next Element is represented by N
     *
     *  Input Linked List:
     *      1 -> 1 -> 2 -> null
     *      C    N
     *
     *  Step 1: Current Element Value is Same as Next element Value, so we remove N element from the Linked List
     *      1 -> 2 -> null
     *      C    N
     *
     *  Step 2: Current Element Value is not Same as Next Element Value, so we update current reference
     *      1 -> 2 -> null
     *           C    N
     *
     *  Step 3: Next Element is null, so we exit while loop
     *
     **/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current != null && current.next != null) {
            if(current.val == current.next.val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return head;
    }
}
