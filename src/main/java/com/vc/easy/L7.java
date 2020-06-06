package com.vc.easy;

/**
 *  Problem No: 7
 *  Category: data structures and algorithms
 *  Tags: Math, amazon, facebook, google, microsoft, leetcode
 *  Title: Reverse Integer
 *  Description: Given a 32-bit signed integer, reverse digits of integer
 *
 *  ## Problem Statement
 *  Given a 32-bit signed integer, reverse digits of integer
 *
 *  ## Gotchas
 *  Problem looks fairly simple, but there are two gotchas that we have to be careful about
 *  1. Given number can be negative
 *  2. Reversed number might overflow out the range of integer
 *
 *  ## Algorithm
 *  With that in mind, the algorithm is as below
 *  1. If Given number is negative, set a flag and reverse the sign of current number
 *  2. While Given number > 0
 *     2.1. Take last digit of given number and append the digit to new number
 *     2.2. Divide the given number by 10
 *     2.3. Continue until Given Number > 0
 **/
class L7 {
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
