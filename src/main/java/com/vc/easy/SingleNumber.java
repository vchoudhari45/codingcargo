package com.vc.easy;


/*****
 *  Problem No: 136
 *  Category: Data Structures And Algorithms
 *  Tags: Bit Manipulation, XOR Operation, Amazon, Facebook, Microsoft, Leetcode, Easy
 *  Title: Single Number
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a non-empty array of integers, every element appears twice except for one, Find that single one. Your algorithm should have a linear runtime complexity, and should not use any extra memory. It is an easy problem that uses Bit Manipulation to solve the problem.
 *  Description: Given a non-empty array of integers, every element appears twice except for one, find that single one. Your algorithm should have a linear runtime complexity and should not use any extra memory.
 *  Input: [2,2,1]
 *  Output: 1
 *  Similar Question: Single Number II, Single Number III, Missing Number, Find the Duplicate Number, Find the Difference.
 *****/

class SingleNumber {
    /**
     *  If you XOR a number with itself, you will get zero.
     **/
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
