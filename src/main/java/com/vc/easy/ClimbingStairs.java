package com.vc.easy;


/*****
 *  Problem No: 70
 *  Category: Data Structures And Algorithms
 *  Tags: Dynamic Programming, Fibonacci Series, Amazon, Facebook, Google, Microsoft, Leetcode, Easy
 *  Title: Climbing Stairs
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, You are climbing a stair case and It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? It is an easy problem that uses Fibonacci Series to solve the problem.
 *  Description: You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *  Input: 2
 *  Output: 2
 *  Input: 3
 *  Output: 3
 *  Input: 4
 *  Output: 5
 *  Similar Question: Shortest Palindrome, Repeated Substring Pattern
 *****/

class ClimbingStairs {
    /**
     *  Algorithm:
     *
     *  As the problem statements states, you can either climb 1 steps or 2 steps from any position.
     *  Input:  3
     *  Output: 3
     *
     *  Stair: 0 -> We will start Jumps from here and we can either Jump 2 Steps or 1 Step
     *
     *  Stair: 1 -> To Reach Stair 1, You have only one option, Jump from Stair 0 to Stair 1
     *
     *
     *  Stair: 2 -> To Reach Stair 2, You have 2 Options,
     *              Either Jump 2 Steps
     *              Or Jump 1 Step from Stair 1
     *              So Total 2 Options to Reach Stair 2
     *
     *
     *  Stair: 3 -> To Reach Stair 3, You have 3 Options,
     *              Either Jump 2 Steps from Stair 1
     *              Or Jump 1 Step from Stair 2 (But Wait, to reach Stair 2 We have two options, so we have 2 Options here)
     *              So Total we have 3 Options to Reach Stair 3
     *
     *
     *  Stair: 4 -> To Reach Stair 4, You have  Options
     *              Either Jump 2 Steps from Stair 2 (But we already have 2 Options to Reach Stair 2, so we have 2 Options here)
     *              Or Jump 1 Step from Stair 3 (But we already have 3 Options to Reach Stair 2, so we have 3 Options here)
     *              So Total we have 5 Options to Reach Stair 4
     *
     *  And so on..... This is classic Fibonacci Series
     *
     **/
    public int climbStairs(int n) {
        //Base Condition
        if(n == 0 || n == 1) return 1;

        //Fibonacci Series
        int first = 1, second = 1;
        int res = 0;
        for(int i = 2; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}
