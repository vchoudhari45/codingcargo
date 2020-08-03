package com.vc.easy;

import com.vc.hard.ListNode;

/*****
 *  Problem No: 141
 *  Category: Data Structures And Algorithms
 *  Tags: Linked List, Two Pointer, Amazon, Facebook, Microsoft, Leetcode, Easy
 *  Title: Linked List Cycle
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a linked list, determine if it has a cycle in it. It is an easy problem that uses Two Pointer Technique to solve the problem.
 *  Description: Given a linked list, determine if it has a cycle in it. To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *  Input: head = [3,2,0,-4], pos = 1
 *  Output: true
 *  Similar Question: Linked List Cycle II, Happy Number
 *****/

public class LinkedListCycle {
    /**
     *  Algorithm:
     *  We use Two pointer Technique to solve the problem
     *  Pointer 1 is called hare which moves two steps
     *  Pointer 2 is called tortoise which moves one step
     *
     *  If Linked List doesn't have a cycle, Pointer 1 will eventually become null and our algorithm will return false
     *  But let's say if our Linked List has a cycle, Pointer 1(hare) will start second iterator in a cycle and eventually hit Pointer 2(tortoise)
     *  Because considering their speed ratio which is 2:1, when hare will iterate over cycle two time, tortoise have finished iterating over a cycle just once, and both of them eventually meet at point where cycle starts.
     **/
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode hare = head;
        ListNode tortoise = head;
        while(hare != null && hare.next != null) {
            hare = hare.next;
            hare = hare.next;
            tortoise = tortoise.next;
            if(hare == tortoise) return true;
        }
        return false;
    }
}