package com.vc.easy;

/*****
 *  Problem No: 27
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Two Pointers, Leetcode, Easy
 *  Title: Remove Element
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an array arr and a value val, remove all instances of that value val in-place and return the new length. It is an easy problem that uses two pointer technique to solve the problem.
 *  Description: Given an array arr and a value val, remove all instances of that value val in-place and return the new length.
 *  Input: [3,2,2,3]
 *  Output: 3
 *  Input: [0,1,2,2,3,0,4,2]
 *  Output: 2
 *  Similar Question: Remove Duplicates from Sorted Array, Remove Linked List Elements, Move Zeroes
 *****/

class RemoveElement {
    /**
     *  Idea is to use two pointer as below
     *  1. insertIndex: Index up to which no two consecutive elements are duplicate.
     *  2. i: Pointer which iterate over the elements of array
     *
     *  Algorithm:
     *  if   arr[i] == val then we skip element at ith index
     *  else arr[i] != val then we insert element at ith index to insertIndex + 1
     **/
    public int removeElement(int[] arr, int val) {
        if(arr == null || arr.length == 0) return 0;
        int insertIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != val) {
                arr[insertIndex++] = arr[i];
            }
        }
        return insertIndex;
    }
}
