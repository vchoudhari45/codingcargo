package com.vc.easy;

/*****
 *  Problem No: 303
 *  Category: Data Structures And Algorithms
 *  Tags: Dynamic Programming, Google, Leetcode, Easy
 *  Title: Range Sum Query - Immutable
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive. It is an easy problem that uses Dynamic Programming to solve the problem.
 *  Description: Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *  Input: nums = [-2, 0, 3, -5, 2, -1]
 *  Output: sumRange(0, 2) -> 1, sumRange(2, 5) -> -1, sumRange(0, 5) -> -3
 *  Similar Question: Range Sum Query - Mutable, Range Sum Query 2D - Immutable, Maximum Size Subarray Sum Equals k
 *****/

class NumArray {
    private int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }
}
