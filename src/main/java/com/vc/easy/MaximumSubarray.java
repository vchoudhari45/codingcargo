package com.vc.easy;

/*****
 *  Problem No: 53
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Kadane's Algorithm, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Maximum Subarray
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an integer array arr, find the contiguous sub array (containing at least one number) which has the largest sum and return its sum. It is an easy problem that uses Kadane's Algorithm to solve the problem.
 *  Description: Given an integer array arr, find the contiguous sub array (containing at least one number) which has the largest sum and return its sum.
 *  Input: [-2,1,-3,4,-1,2,1,-5,4]
 *  Output: 6
 *  Similar Question: Best Time to Buy and Sell Stock, Maximum Product Subarray, Degree of an Array, Longest Turbulent Subarray
 *****/

class MaximumSubarray {
    /**
     * Algorithm:
     * Brute Force Solution to this problem will be to, start from an index i and try every possible length such that i + length < arr.length.
     * Brute Force Solution will have time complexity of O(n^2)
     *
     * With Kadane's Algorithm we can find maxSumArray in O(n) time as below
     * Start from an index i, Max we can do at index i will be Either
     *      a. Value at index i Or
     *      b. Value at index i + Max At index (i - 1)
     *
     * For e.g.
     * Input Arr   : [-2, 1, -3, 4]
     * Index       : [ 0, 1,  2, 3]
     *
     * Max we can do at index = 0, will be Value at index = 0, in our case -2
     * Max we can do at index = 1, will be Either, Value at Index 1, Which is  1 or Max at index = 0 + Value at Index 1, Which is (-2 + 1) = -1, so we choose  1 as max for index = 1
     * Max we can do at index = 2, will be Either, Value at Index 2, Which is -3 or Max at index = 1 + Value at Index 2, Which is (-3 + 1) = -2, so we choose -2 as max for index = 2
     * Max we can do at index = 3, will be Either, Value at Index 3, Which is  4 or Max at index = 2 + Value at Index 3, Which is (-2 + 4) =  2, so we choose  2 as max for index = 3
     *
     * Max Found so far is 4, so ans should be 4
     **/
    public int maxSubArray(int[] arr) {
        if(arr == null || arr.length == 0) return 0;

        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] + arr[i - 1] > arr[i]) arr[i] = arr[i] + arr[i - 1];
            else arr[i] = arr[i];
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
