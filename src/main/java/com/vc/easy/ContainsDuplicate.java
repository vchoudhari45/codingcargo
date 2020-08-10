package com.vc.easy;

import java.util.Arrays;

/*****
 *  Problem No: 217
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Hash Table, Leetcode, Easy
 *  Title: ContainsDuplicate
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct. It is an easy problem that uses Array Sorting to solve the problem.
 *  Description: Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *  Input: [1,2,3,1]
 *  Output: true
 *  Input: [1,2,3,4]
 *  Output: false
 *  Input: [1,1,1,3,3,4,3,2,4,2]
 *  Output: true
 *  Similar Question: Contains Duplicate II, Contains Duplicate III
 *****/

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}
