package com.vc.easy;

/*****
 *  Problem No: 191
 *  Category: Data Structures And Algorithms
 *  Tags: Bit Manipulation, Facebook, Leetcode, Easy
 *  Title: Number of 1 Bits
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Write a function that takes an unsigned integer and return the number of '1' bits it has. It is an easy problem that uses Bit Manipulation to solve the problem.
 *  Description: Write a function that takes an unsigned integer and return the number of '1' bits it has.
 *  Input: 00000000000000000000000000001011
 *  Output: 3
 *  Input: 00000000000000000000000010000000
 *  Output: 1
 *  Input: 11111111111111111111111111111101
 *  Output: 31
 *  Similar Question: Reverse Bits, Power of Two, Counting Bits, Binary Watch, Hamming Distance, Binary Number with Alternating Bits, Prime Number of Set Bits in Binary Representation
 *****/

class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        while(n != 0) {
            ones = ones + (n & 1);
            n = n >> 1;
        }
        return ones;
    }
}
