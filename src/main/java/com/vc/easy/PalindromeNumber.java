package com.vc.easy;

/*****
 *  Problem No: 9
 *  Category: Data Structures And Algorithms
 *  Tags: Math, Leetcode, Easy
 *  Title: Palindrome Number
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, To determine whether an integer is a palindrome. It is an easy problem that uses the modulo Math technique to solve the problem.
 *  Description: Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *  Input: 121
 *  Output: true
 *  Input: -121
 *  Output: false
 *  Similar Question: String to Integer (atoi), Reverse Bits, Palindrome Number
 *****/

class PalindromeNumber {
    /**
     *  Gotchas
     *  1. Given number can be negative
     *  2. Reversed number might overflow out the range of integer
     *  3. Before reversing the given number, keep old value in some variable like so xOld = x
     *     Because once we have reverse of number we can validate it against the given number like so xNew == x
     *
     *  Algorithm
     *  1. If the given number is negative, set a flag and reverse the sign of a current number.
     *  2. While Given number > 0
     *     2.1. Take the last digit of a given number by doing modulo operation and append that digit to a new number
     *     2.2. Divide the given number by 10
     *     2.3. Continue running Step 2.1 to 2.2 until Given Number > 0
     *  3. Validate if Given number is same as reverse of a number.
     **/
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int xNew = 0;
        int xOld = x;
        while(xOld > 0) {
            int digit = xOld % 10;
            xNew = xNew * 10 + digit;
            xOld = xOld / 10;
        }
        return xNew == x;
    }
}
