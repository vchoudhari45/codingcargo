package com.vc.easy;

import java.util.HashMap;

/*****
 *  Problem No: 219
 *  Category: Data Structures And Algorithms
 *  Tags: Hash Table, Google, Leetcode, Easy
 *  Title: Contains Duplicate II
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k. It is an easy problem that uses Hash Table Data Structure to solve the problem.
 *  Description: Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *  Input: nums = [1,2,3,1], k = 3
 *  Output: true
 *  Input: nums = [1,0,1,1], k = 1
 *  Output: true
 *  Input: nums = [1,2,3,1,2,3], k = 2
 *  Output: false
 *  Similar Question: Contains Duplicate, Contains Duplicate III
 *****/

class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
