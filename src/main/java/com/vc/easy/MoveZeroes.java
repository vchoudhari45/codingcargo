package com.vc.easy;

/*****
 *  Problem No: 283
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Move Zeroes
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements. It is an easy problem that uses Array Data Structure to solve the problem.
 *  Description: Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *  Input: [0,1,0,3,12]
 *  Output: [1,3,12,0,0]
 *  Similar Question: House Robber II, House Robber III, Paint House, Paint Fence, Non-negative Integers without Consecutive Ones, Coin Path, Delete and Earn, Maximum Product Subarray,
 *****/

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int insertAt = 0;
        for(int i = 0; i < nums.length; i++) if(nums[i] != 0) nums[insertAt++] = nums[i];
        while(insertAt < nums.length) nums[insertAt++] = 0;
    }
}
