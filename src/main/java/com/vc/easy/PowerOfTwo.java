package com.vc.easy;

/*****
 *  Problem No: 231
 *  Category: Data Structures And Algorithms
 *  Tags: Math, Leetcode, Easy
 *  Title: Power of Two
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an integer, write a function to determine if it is a power of two. It is an easy problem that uses Math to solve the problem.
 *  Description: Given an integer, write a function to determine if it is a power of two.
 *  Input: 1
 *  Output: true
 *  Input: 16
 *  Output: true
 *  Input: 218
 *  Output: false
 *  Similar Question: Power of Three, Power of Four, Number of 1 Bits
 *****/

class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        /** Divide the number by two until it is divisible by 2 */
        while(n % 2 == 0) n = n / 2;
        return n == 1;
    }
}
