package com.vc.easy;

/*****
 *  Problem No: 263
 *  Category: Data Structures And Algorithms
 *  Tags: Math, Leetcode, Easy
 *  Title: Ugly Number
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Write a program to check whether a given number is an ugly number. Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. It is an easy problem that uses Math to solve the problem.
 *  Description: Write a program to check whether a given number is an ugly number. Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *  Input: 6
 *  Output: true
 *  Input: 8
 *  Output: true
 *  Input: 14
 *  Output: false
 *  Similar Question: Happy Number, Count Primes, Ugly Number II
 *****/

class UglyNumber {
    public boolean isUgly(int num) {
        if(num == 0) return false;
        while(num % 2 == 0) num = num / 2;
        while(num % 3 == 0) num = num / 3;
        while(num % 5 == 0) num = num / 5;
        return num == 1;
    }
}
