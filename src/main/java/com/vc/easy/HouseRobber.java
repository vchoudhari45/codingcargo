package com.vc.easy;


/*****
 *  Problem No: 198
 *  Category: Data Structures And Algorithms
 *  Tags: Dynamic Programming, Amazon, Facebook, Google, Leetcode, Easy
 *  Title: House Robber
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night. It is an easy problem that uses Dynamic Programming to solve the problem.
 *  Description: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night. Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *  Input: nums = [1,2,3,1]
 *  Output: 4
 *  Input: nums = [2,7,9,3,1]
 *  Output: 12
 *  Similar Question: House Robber II, House Robber III, Paint House, Paint Fence, Non-negative Integers without Consecutive Ones, Coin Path, Delete and Earn, Maximum Product Subarray,
 *****/

class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int currentHouse = 0, prevHouse = 0, prevToPrevHouse = 0;
        for(int i = 0; i < nums.length; i++) {
            currentHouse = Math.max(prevToPrevHouse + nums[i], prevHouse);
            prevToPrevHouse = prevHouse;
            prevHouse = currentHouse;
        }
        return currentHouse;
    }
}
