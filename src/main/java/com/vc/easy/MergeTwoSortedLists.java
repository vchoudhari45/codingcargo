package com.vc.easy;

import com.vc.hard.ListNode;

/*****
 *  Problem No: 21
 *  Category: Data Structures And Algorithms
 *  Tags: Linked List, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Merge Two Sorted Lists
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem which, Merge two sorted linked lists and return it as a new sorted list, It is an easy problem that uses Linked List Data Structure.
 *  Description: Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 *  Input: L1: 1->2->4, L2: 1->3->4
 *  Output: 1->1->2->3->4->4
 *  Similar Question: Merge k Sorted Lists, Merge Sorted Array, Sort List, Shortest Word Distance II
 *****/

class MergeTwoSortedLists {
    /**
     *  Definition for singly-linked list.
     *  public class ListNode {
     *      int val;
     *      ListNode next;
     *      ListNode() {}
     *      ListNode(int val) { this.val = val; }
     *      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     *  }
     *
     *  Gotcha is to not forget iterating over pending elements from either of L1 & l2 LinkedList.
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        final ListNode head = new ListNode(-1);
        ListNode res = head;

        /**
         * Iterate over both lists until one of the list is null
         **/
        while(l1 != null && l2 != null) {
            /**
             *  For a LinkedList with the smallest element at its head, point its head to its next element and append its head element to res LinkedList.
             **/
            if(l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            }
            else {
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }
        }

        /**
         *  Iterate over any pending elements from L1, which might be possible in case below
         *  L1: 1 -> 1
         *  L2: 2 -> 2
         **/
        while(l1 != null) {
            res.next = l1;
            l1 = l1.next;
            res = res.next;
        }

        /**
         *  Iterate over any pending elements from L2, same as above
         **/
        while(l2 != null) {
            res.next = l2;
            l2 = l2.next;
            res = res.next;
        }
        return head.next;
    }
}