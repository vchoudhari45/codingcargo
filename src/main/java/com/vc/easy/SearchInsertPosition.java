package com.vc.easy;

/*****
 *  Problem No: 35
 *  Category: Data Structures And Algorithms
 *  Tags: Binary Search, Array, Amazon, Leetcode, Easy
 *  Title: Search Insert Position
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. It is an easy problem that uses Binary Search Algorithm to solve the problem.
 *  Description: Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *  Input: arr = [1,3,5,6], target = 5
 *  Output: 2
 *  Input: arr = [1,3,5,6], target = 2
 *  Output: 1
 *  Input: arr = [1,3,5,6], target = 7
 *  Output: 4
 *  Input: arr = [1,3,5,6], target = 0
 *  Output: 0
 *  Similar Question: First Bad Version
 *****/

class SearchInsertPosition {
    /**
     *  Algorithm:
     *  We use Binary Search Algorithm Here
     *  But we try to find the target element in an array, whose index is as low as possible
     *      For e.g.
     *      Input: arr = [1, 3, 3, 5, 6], target = 3
     *             index [0  1  2  3  4]
     *      Our Binary Search should return index 1, instead of index 2
     *      Because our question ask us to return an index where it should insert a target element, if we don't find an target element in an array.
     *
     *      To do so we
     *      1. Assign lo = mid + 1, if current array element is less than target
     *      2. But assign hi = mid(and not mid - 1), if current array element is less than or equal to target
     **/
    public int searchInsert(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
