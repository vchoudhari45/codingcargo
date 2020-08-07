package com.vc.easy;

/*****
 *  Problem No: 189
 *  Category: Data Structures And Algorithms
 *  Tags: Linked List, Amazon, Facebook, Google, Leetcode, Easy
 *  Title: Rotate Array
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an array, rotate the array to the right by k steps, where k is non-negative. It is an easy problem that uses Array Data Structure to solve the problem.
 *  Description: Given an array, rotate the array to the right by k steps, where k is non-negative. Algorithm should work without using any extra space and in liner time.
 *  Input: nums = [1,2,3,4,5,6,7], k = 3
 *  Output: [5,6,7,1,2,3,4]
 *  Input: nums = [-1,-100,3,99], k = 2
 *  Output: [3,99,-1,-100]
 *  Similar Question: Rotate List, Reverse Words in a String II
 *****/

class RotateArray {
    /**
     * Algorithm:
     * Reverse the whole array,
     * Reverse k - 1 elements from beginning And
     * Reverse n - k elements from end
     **/
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int from, int to) {
        while(from < to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
    }
}
