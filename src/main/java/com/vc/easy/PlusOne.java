package com.vc.easy;

/*****
 *  Problem No: 66
 *  Category: Data Structures And Algorithms
 *  Tags: Array, Facebook, Google, Leetcode, Easy
 *  Title: Plus One
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given a non-empty array of digits representing a non-negative integer, Add one to the integer. It is an easy problem that uses Array Data Structure to solve the problem.
 *  Description: Given a non-empty array of digits representing a non-negative integer, Add one to the integer. The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit. You may assume the integer does not contain any leading zero, except the number 0 itself.
 *  Input: [1,2,3]
 *  Output: [1,2,4]
 *  Input: [4,3,2,1]
 *  Output: [4,3,2,2]
 *  Similar Question: Multiply Strings, Add Binary, Plus One Linked List, Add to Array-Form of Integer
 *****/
class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--) {
            if(digits[i] == 9) {
                digits[i] = 0;
            }
            else {
                digits[i]++;
                return digits;
            }
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}