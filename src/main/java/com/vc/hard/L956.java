package com.vc.hard;

import java.util.*;

class L956 {
    public int tallestBillboard(int[] rods) {
        int left = 0, right = 0, currentIndex = 0;
        return solve(currentIndex, left, right, rods, new HashMap<String, Integer>());
    }

    private int solve(int index, int left, int right, int[] rods, HashMap<String, Integer> memo) {
        if(index == rods.length) {
            if(left == right) return left;
            return -1;
        }

        //If you are at specific index in an array and you encounter the
        //Same abs difference between left & right then you alredy know the answer
        //We save the answer as it add X size to max of left & right
        String key = index+" "+Math.abs(left - right);
        if(memo.containsKey(key)) {
            return memo.get(key) == -1 ? -1 : Math.max(left, right) + memo.get(key);
        }

        int l = solve(index + 1, left + rods[index], right, rods, memo); //add to left
        int r = solve(index + 1, left, right + rods[index], rods, memo); //add to right
        int s = solve(index + 1, left, right, rods, memo);              //skip

        int res = Math.max(s, Math.max(l, r));

        memo.put(key, res == -1 ? -1 : res - Math.max(left, right));
        return res;
    }
}