package com.vc.easy;

import java.util.*;

/*****
 *  Problem No: 1
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Hash Table, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Two Sum
 *  MetaDescription: Java Solution to a Data Structures And Algorithms problem, Given an array of integers, return indices of two numbers such that they add up to specific target. It is an easy problem that is part of Amazon, Facebook, Google, Microsoft Technical Interview Question list, and can be solved using Array & HashMap Data Structure.
 *  Description: Given an array of integers, return indices of two numbers such that they adds up to specific target.
 *  Input:  arr = [2, 7, 11, 15], target = 9,
 *  Output: [0, 1]
 *  Similar Question: 3Sum, 4Sum, Two Sum II - Input array is sorted, Two Sum III - Data structure design, Subarray Sum Equals K, Two Sum IV - Input is a BST, Two Sum Less Than K
 *****/

class TwoSum {
    /**
     *  Algorithm:
     *  1. Create a HashMap to hold an element and it's corresponding index
     *  2. Iterate over an input array and
     *      2.1. Check if we have an element in HashMap which is equal to target - current array element
     *      2.2. If we find such element in HashMap return it's index and current element's index as an answer
     *      2.3. Else add current array element and it's corresponding index into HashMap
     *      2.4  Continue running Step 2.1 to 2.3 until all the elements in an array are iterated
     **/
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(target - arr[i])) return new int[] {map.get(target - arr[i]), i};
            map.put(arr[i], i);
        }
        return new int[] {-1, -1};
    }
}