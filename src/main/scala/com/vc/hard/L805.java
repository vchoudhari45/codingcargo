package com.vc.hard;

import java.util.*;

class L805 {
    //https://leetcode.com/problems/split-array-with-same-average/discuss/120660/Java-accepted-recursive-solution-with-explanation
    public boolean splitArraySameAverage(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
        for(int i = 1; i <= arr.length / 2; i++) {
            if(sum * i % arr.length == 0) {
                if(solve(arr, 0, sum * i / arr.length, i)) return true;
            }
        }
        return false;
    }

    private boolean solve(int[] arr, int index, int sum, int count) {
        if(count == 0) return sum == 0;
        else {
            for(int i = index; i < arr.length; i++){
                if(i > index && arr[i] == arr[i - 1]) continue;
                if(solve(arr, i + 1, sum - arr[i], count - 1)) return true;
            }
            return false;
        }
    }
}