package com.vc.easy;

/*****
 *  Problem No: 268
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Math, Amazon, Facebook, Microsoft, Leetcode, Easy
 *  Title: Missing Number
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array. It is an easy problem that uses Math to solve the problem.
 *  Description: Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *  Input: [3,0,1]
 *  Output: 2
 *  Input: [9,6,4,2,3,5,7,0,1]
 *  Output: 8
 *  Similar Question: First Missing Positive, Single Number, Find the Duplicate Number, Couples Holding Hands
 *****/

class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for(int i = 0; i < n; i++) sum -= nums[i];
        return sum;
    }
}
