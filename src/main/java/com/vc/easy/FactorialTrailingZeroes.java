package com.vc.easy;

/*****
 *  Problem No: 172
 *  Category: Data Structures And Algorithms
 *  Tags: Math, Facebook, Leetcode, Easy
 *  Title: Factorial Trailing Zeroes
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an integer n, return the number of trailing zeroes in n!. It is an easy problem that uses Math to solve the problem.
 *  Description: Given an integer n, return the number of trailing zeroes in n!.
 *  Input: 3
 *  Output: 0
 *  Input: 5
 *  Output: 1
 *  Similar Question: Number of Digit One, Preimage Size of Factorial Zeroes Function
 *****/

class FactorialTrailingZeroes {
    /**
     * Algorithm: Zero is multiply of 5 * 2 so divide given number by 5 until number is zero
     **/
    public int trailingZeroes(int n) {
        int res = 0;
        while(n > 0) {
            n = n / 5;
            res += n;
        }
        return res;
    }
}
