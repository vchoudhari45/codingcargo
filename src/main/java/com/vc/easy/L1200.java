package com.vc.easy;

import java.util.*;

class L1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int minGap = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            int gap = arr[i + 1] - arr[i];
            if(minGap > gap) {
                minGap = gap;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
            else if(minGap == gap) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
}