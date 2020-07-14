package com.vc.easy;

/*****
 *  Problem No: 69
 *  Category: Data Structures And Algorithms
 *  Tags: Math, Binary Search, Amazon, Microsoft, Leetcode, Easy
 *  Title: SqrtX
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Compute and return the square root of x, where x is guaranteed to be a non-negative integer. It is an easy problem that uses Binary Search Algorithm to solve the problem.
 *  Description: Compute and return the square root of x, where x is guaranteed to be a non-negative integer. Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *  Input: 4
 *  Output: 2
 *  Input: 8
 *  Output: 2
 *  Similar Question: PowX, Valid Perfect Square
 *****/

class SqrtX {
    /**
     *  Binary Search has three patterns as below
     *
     *  Let's say we are trying to find index of Number 2 in an array of Integer [0, 1, 1, 2, 2, 3]
     *
     *  1. Find the number towards the left side(So, in our example we should return index as 3)
     *     int numberToSearch = 2
     *     while(lo < hi) {
     *        int mid = lo + (hi - lo) / 2;
     *        if(mid > numberToSearch) lo = mid + 1;
     *        else hi = mid;
     *     }
     *     return lo;
     *
     *  2. Find the number towards the right side(So, in our example we should return index as 4)
     *     int numberToSearch = 2
     *     while(lo < hi) {
     *          int mid = lo + (hi - lo) / 2;
     *          if(mid < numberToSearch) hi = mid - 1;
     *          else lo = mid;
     *     }
     *     return lo;
     *
     *  3. Return any index which has value to search,(so In our example we should return index 3 or 4)
     *     while(lo <= hi) {
     *          int mid = lo + (hi - lo) / 2;
     *          if(mid < numberToSearch) hi = mid - 1;
     *          else if(mid > numberToSearch) lo = mid + 1;
     *          else return mid;
     *     }
     *     return hi;
     *
     *     Pattern 3 make sense for Sqrt
     **/
    public int mySqrt(int x) {
        if(x < 2) return x;
        int lo = 0;
        int hi = x / 2;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long square = (long)mid * mid;
            if(square < x) lo = mid + 1;
            else if(square > x) hi = mid - 1;
            else return mid;
        }
        return hi;
    }
}
