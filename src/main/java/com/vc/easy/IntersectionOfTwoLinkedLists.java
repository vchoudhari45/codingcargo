package com.vc.easy;

import com.vc.hard.ListNode;

/*****
 *  Problem No: 160
 *  Category: Data Structures And Algorithms
 *  Tags: Linked List, Amazon, Facebook, Google, Leetcode, Easy
 *  Title: Intersection of Two Linked Lists
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Write a program to find the node at which the intersection of two singly linked lists begins. It is an easy problem that uses Linked List Data Structure to solve the problem.
 *  Description: Write a program to find the node at which the intersection of two singly linked lists begins.
 *  Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 *  Output: Intersected at '8'
 *  Similar Question: Minimum Index Sum of Two Lists
 *****/

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;

        while(currentA != currentB) {
            currentA = currentA == null ? headB : currentA.next;
            currentB = currentB == null ? headA : currentB.next;
        }
        return currentA;
    }
}