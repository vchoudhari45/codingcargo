package com.vc.easy;

/*****
 *  Problem No: 167
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Binary Search, Amazon, Leetcode, Easy
 *  Title: Two Sum II Input array is sorted
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number. It is an easy problem that uses Binary Search Algorithm to solve the problem.
 *  Description: Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *  Input: numbers = [2,7,11,15], target = 9
 *  Output: [1,2]
 *  Similar Question: Two Sum, Two Sum IV - Input is a BST, Two Sum Less Than K
 *****/

class TwoSumIIInputArrayIsSorted {
    /**
     * Algorithm: Binary Search
     **/
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;
        while(lo <= hi) {
            int sum = numbers[lo] + numbers[hi];
            if(sum > target) hi--;
            else if(sum < target) lo++;
            else return new int[]{lo + 1, hi + 1};
        }
        return new int[]{-1, -1};
    }
}
