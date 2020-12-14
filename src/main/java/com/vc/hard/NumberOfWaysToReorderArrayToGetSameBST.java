package com.vc.hard;

import java.util.*;

class NumberOfWaysToReorderArrayToGetSameBst {
    private long[][] pascal;
    private int MOD = (int)1e9 + 7;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        generatePascal(n + 1);

        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) numbers.add(nums[i]);

        //-1 because one permutation is already given as an input
        return (int)helper(numbers) - 1;
    }

    private long helper(List<Integer> nums) {
        if(nums.size() <= 2) return 1;

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for(int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            if(num > root) right.add(num);
            else left.add(num);
        }

        /**
             How many different ways we can arrange left.size() elements in left.size() + right.size() elements

             Let's say we have [3, 4, 5, 1, 2] as original array with root value is 3

             [1, 2] left sub-tree, left.size() = 2
             [4, 5] right sub-tree, right.size() = 2

             In all of below permutations, we keep relative position in left & right subtree,
             But we can absolute position
             [1, 2, 4, 5]
             [1, 4, 2, 5]
             [1, 4, 5, 2]
             [4, 1, 2, 5]
             [4, 1, 5, 2]
             [4, 5, 1, 2]
         */
        return pascal[left.size() + right.size()][left.size()] % MOD *
                helper(left) % MOD *
                helper(right) % MOD;
    }

    private void generatePascal(int n) {
        pascal = new long[n][n];
        for(int row = 0; row < n; row++) pascal[row][0] = pascal[row][row] = 1;

        for(int row = 2; row < n; row++) {
            for(int col = 1; col < row; col++) {
                pascal[row][col] = (pascal[row - 1][col] + pascal[row - 1][col - 1]) % MOD;
            }
        }
    }
}