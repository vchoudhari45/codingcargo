package com.vc.easy;

/*****
 *  Problem No: 258
 *  Category: Data Structures And Algorithms
 *  Tags: Tree, Leetcode, Easy
 *  Title: Add Digits
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a non-negative integer num, repeatedly add all its digits until the result has only one digit. It is an easy problem that uses Tree Data Structure to solve the problem.
 *  Description: Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *  Input: 38
 *  Output: 2
 *  Similar Question: Math
 *****/

class AddDigits {
    public int addDigits(int num) {
        while(num > 9) num = getNext(num);
        return num;
    }

    private int getNext(int num) {
        int res = 0;
        while(num > 0) {
            int digit = num % 10;
            res += digit;
            num = num / 10;
        }
        return res;
    }
}
