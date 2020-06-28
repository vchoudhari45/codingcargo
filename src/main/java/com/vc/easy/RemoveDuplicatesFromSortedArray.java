package com.vc.easy;

/*****
 *  Problem No: 26
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Two Pointers, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Remove Duplicates from Sorted Array
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a sorted array arr, remove duplicates in-place such that each element appears only once and returns the new length. It is an easy problem that uses two pointer technique to solve the problem.
 *  Description: Given a sorted array arr, remove duplicates in-place such that each element appear only once and return the new length.
 *  Input: [1,1,2]
 *  Output: 2
 *  Input: [0,0,1,1,1,2,2,3,3,4]
 *  Output: 5
 *  Similar Question: Remove Element, Remove Duplicates from Sorted Array II
 *****/

class RemoveDuplicatesFromSortedArray {
    /**
     *  Idea is to use two pointer as below
     *  1. insertIndex: Index up to which no two consecutive elements are duplicate.
     *  2. i: Pointer which iterate over the elements of array
     *
     *  Algorithm:
     *  if   arr[insertIndex] == arr[i] then we skip element at ith index
     *  else arr[insertIndex] != arr[i] then we insert element at ith index to insertIndex + 1
     **/
    public int removeDuplicates(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int insertIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != arr[insertIndex]) {
                arr[++insertIndex] = arr[i];
            }
        }
        return insertIndex + 1;
    }
}