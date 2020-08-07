package com.vc.easy;

/*****
 *  Problem No: 190
 *  Category: Data Structures And Algorithms
 *  Tags: Bit Manipulation, Leetcode, Easy
 *  Title: Reverse Bits
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Reverse bits of a given 32 bits unsigned integer. It is an easy problem that uses Bit Manipulation to solve the problem.
 *  Description: Reverse bits of a given 32 bits unsigned integer.
 *  Input: 00000010100101000001111010011100
 *  Output: 00111001011110000010100101000000
 *  Similar Question: Reverse Integer, Number of 1 Bits
 *****/

public class ReverseBits {
    /**
     *  you need treat n as an unsigned value
     *  Algorithm: Reverse bits of an integer
     **/
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            if((n & 1) == 1) res += 1;
            n >>= 1;
        }
        return res;
    }
}
