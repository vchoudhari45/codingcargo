package com.vc.easy;

/*****
 *  Problem No: 326
 *  Category: Data Structures And Algorithms
 *  Tags: Math, Leetcode, Easy
 *  Title: Power of Three
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given an integer, write a function to determine if it is a power of three. It is an easy problem that uses Math to solve the problem.
 *  Description: Given an integer, write a function to determine if it is a power of three.
 *  Input: 27
 *  Output: true
 *  Input: 0
 *  Output: false
 *  Input: 9
 *  Output: true
 *  Input: 45
 *  Output: false
 *  Similar Question: Power of Two, Power of Four
 *****/

class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n == 0) return false;
        while(n % 3 == 0) n = n / 3;
        return n == 1;
    }
}
