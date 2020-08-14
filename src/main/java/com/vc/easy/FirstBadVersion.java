package com.vc.easy;

import java.util.Random;

/*****
 *  Problem No: 278
 *  Category: Data Structures And Algorithms
 *  Tags: Binary Search, Facebook, Google, Leetcode, Easy
 *  Title: First Bad Version
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad. Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad. You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API. It is an easy problem that uses Binary Search to solve the problem.
 *  Description: You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad. Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad. You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *  Input: Given n = 5, and version = 4 is the first bad version.
 *  Output: Then 4 is the first bad version.
 *  Similar Question: Find First and Last Position of Element in Sorted Array, Search Insert Position, Guess Number Higher or Lower
 *****/

class FirstBadVersion {
    /**
     *  Minimize the Maximum Pattern for Binary Search
     **/
    public int firstBadVersion(int n) {
        long lo = 0;
        long hi = (long)n + 1;
        while(lo < hi) {
            int mid = (int)(lo + (hi - lo) / 2);
            if(!isBadVersion(mid)) lo = mid + 1;
            else hi = mid;
        }
        return (int)lo;
    }

    private Random random = new Random();
    public boolean isBadVersion(int mid) {
        return random.nextBoolean();
    }
}
