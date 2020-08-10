package com.vc.easy;

/*****
 *  Problem No: 202
 *  Category: Data Structures And Algorithms
 *  Tags: Linked List, Amazon, Facebook, Google, Leetcode, Easy
 *  Title: Happy Number
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Write an algorithm to determine if a number n is "happy". It is an easy problem that uses Linked List Data Structure to solve the problem.
 *  Description: Write an algorithm to determine if a number n is "happy". A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers. Return True if n is a happy number, and False if not.
 *  Input: 19
 *  Output: true (Explanation: 1^2 + 9^2 = 82, 8^2 + 2^2 = 68, 6^2 + 8^2 = 100, 1^2 + 0^2 + 0^2 = 1)
 *  Similar Question: Minimum Index Sum of Two Lists
 *****/

class HappyNumber {
    public boolean isHappy(int n) {
        int hare = n;
        int tortoise = n;
        do {
            tortoise = getNext(tortoise);
            hare = getNext(hare);
            hare = getNext(hare);
        } while(hare != tortoise);
        return hare == 1;
    }

    private int getNext(int number) {
        int res = 0;
        while(number != 0) {
            int digit = number % 10;
            res += Math.pow(digit, 2);
            number = number / 10;
        }
        return res;
    }
}
