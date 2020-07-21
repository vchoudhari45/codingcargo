package com.vc.easy;


/*****
 *  Problem No: 88
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Two Pointers, Amazon, Facebook, Google, Leetcode, Easy
 *  Title: Merge Sorted Array
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array. It is an easy problem that uses Array Data Structure & Two Pointer Technique to solve the problem.
 *  Description: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array. You may assume that nums1 has enough space to hold additional elements from nums2.
 *  Input:
 *  nums1 = [1,2,3,0,0,0], m = 3
 *  nums2 = [2,5,6],       n = 3
 *  Output: [1,2,2,3,5,6]
 *  Similar Question: Merge Two Sorted Lists, Squares of a Sorted Array, Interval List Intersections
 *****/

class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        int index = m + n - 1;
        while(first >= 0 && second >= 0) {
            if(nums1[first] > nums2[second]) {
                nums1[index--] = nums1[first--];
            }
            else {
                nums1[index--] = nums2[second--];
            }
        }

        while(first >= 0) {
            nums1[index--] = nums1[first--];
        }

        while(second >= 0) {
            nums1[index--] = nums2[second--];
        }
    }
}