package com.vc.easy;

import com.vc.hard.ListNode;

/*****
 *  Problem No: 237
 *  Category: Data Structures And Algorithms
 *  Tags: Linked List, Google, Leetcode, Easy
 *  Title: Delete Node in a Linked List
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Write a function to delete a node (except the tail) in a singly linked list, given only access to that node. It is an easy problem that uses Linked List Data Structure to solve the problem.
 *  Description: Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *  Input: head = [4,5,1,9], node = 5
 *  Output: [4,1,9]
 *  Input: head = [4,5,1,9], node = 1
 *  Output: [4,5,9]
 *  Similar Question: Remove Linked List Elements
 *****/

class DeleteNodeInALinkedList {
    /**
     * Question says given node can't be tail node, so node.next will not be NULL
     **/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}