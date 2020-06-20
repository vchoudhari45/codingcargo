package com.vc.easy;

import java.util.*;

/*****
 *  Problem No: 1
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Hash Table, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Two Sum
 *  Description: Given an array of integers, return indices of two numbers such that they adds up to specific target
 *  Similar Question: 3Sum, 4Sum, Two Sum II - Input array is sorted, Two Sum III - Data structure design, Subarray Sum Equals K, Two Sum IV - Input is a BST, Two Sum Less Than K
 *****/

class L1 {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        /**
         *  Algorithm:
         *  1. Create a HashMap to hold an element and it's corresponding index
         *  2. Iterate over an input array and
         *      2.1. Check if we have an element in HashMap which is equal to target - current array element
         *      2.2. If we find such element in HashMap return it's index and current element's index as an answer
         *      2.3. Else add current array element and it's corresponding index into HashMap
         *      2.4  Continue running Step 2.1 to 2.3 until all the elements in an array are iterated
         **/
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(target - arr[i])) return new int[] {map.get(target - arr[i]), i};
            map.put(arr[i], i);
        }
        return new int[] {-1, -1};
    }
}