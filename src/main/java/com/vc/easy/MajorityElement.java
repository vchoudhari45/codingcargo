package com.vc.easy;

/*****
 *  Problem No: 169
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Majority Element
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. It is an easy problem that uses Array Data Structure to solve the problem.
 *  Description: Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *  Input: [3,2,3]
 *  Output: 3
 *  Input: [2,2,1,1,1,2,2]
 *  Output: 2
 *  Similar Question: Majority Element II, Check If a Number Is Majority Element in a Sorted Array
 *****/

class MajorityElement {
    /**
     *  Algorithm:
     *  If we iterate over all the elements in an array count of an majority element will be at least 1 if it appears more than n / 2 times
     **/
    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                res = nums[i];
                count = 1;
            }
            else if(res == nums[i]) count++;
            else count--;
        }
        return res;
    }
}
