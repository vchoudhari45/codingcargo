package com.vc.easy;

/*****
 *  Problem No: 7
 *  Category: Data Structures And Algorithms
 *  Tags: Math, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Reverse Integer
 *  Description: Given a 32-bit signed integer, reverse digits of integer
 *  Similar Question: String to Integer (atoi), Reverse Bits, Palindrome Number
 *****/

class L7 {
    /**
     *  Gotchas
     *  Problem looks fairly simple, but there are two gotchas that we have to be careful about
     *  1. Given number can be negative
     *  2. Reversed number might overflow out the range of integer
     *
     *  Algorithm
     *  1. If the given number is negative, set a flag and reverse the sign of a current number.
     *  2. While Given number > 0
     *     2.1. Take the last digit of a given number by doing modulo operation and append that digit to a new number
     *     2.2. Divide the given number by 10
     *     2.3. Continue running Step 2.1 to 2.2 until Given Number > 0
     **/
    public int reverse(int x) {
        long res = 0;
        boolean isNeg = false;
        if(x < 0) {
            x = -x;
            isNeg = true;
        }
        while(x > 0) {
            int digit = x % 10;
            res = res * 10 + digit;
            x = x / 10;
        }
        res = isNeg ? -res : res;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        else return (int)res;
    }
}
