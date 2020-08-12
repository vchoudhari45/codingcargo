package com.vc.easy;

import com.vc.hard.ListNode;

/*****
 *  Problem No: 234
 *  Category: Data Structures And Algorithms
 *  Tags: Linked List, Two Pointers,  Amazon, Facebook, Microsoft, Leetcode, Easy
 *  Title: Palindrome Linked List
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a singly linked list, determine if it is a palindrome. It is an easy problem that uses Linked List Data Structure to solve the problem.
 *  Description: Given a singly linked list, determine if it is a palindrome.
 *  Input: 1->2
 *  Output: false
 *  Input: 1->2->2->1
 *  Output: true
 *  Similar Question: Palindrome Number, Valid Palindrome, Reverse Linked List
 *****/

class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode tortoise = head;
        ListNode hare = head;

        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }

        if(hare != null) tortoise = tortoise.next; //If odd number of elements move tortoise to next node

        ListNode firstHalf = head;
        ListNode secondHalf = reverse(tortoise);

        while(secondHalf != null) {
            if(firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        final ListNode prev = new ListNode(-1);
        prev.next = head;
        final ListNode current = prev.next;
        ListNode next = current.next;

        while(next != null) {
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = current.next;
        }
        return prev.next;
    }
}