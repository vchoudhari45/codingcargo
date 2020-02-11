package com.vc.hard;

import java.util.*;

//TLE: Work on fixing it

class L1187 {
    HashMap<String, Integer> memo = new HashMap<>();

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < arr2.length; i++) map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);

        int res = solve(0, Integer.MIN_VALUE, arr1, map);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int solve(int index1, int prev, int[] arr1, TreeMap<Integer, Integer> arr2) {
        if(index1 == arr1.length) return 0;

        String key = index1+" "+prev;
        if(memo.containsKey(key)) memo.get(key);

        //keep the current index
        int keep = Integer.MAX_VALUE;
        if(arr1[index1] > prev) {
            keep = solve(index1 + 1, arr1[index1], arr1, arr2);
        }

        //replace the current index
        int replace = Integer.MAX_VALUE;
        if(!arr2.isEmpty()) {
            Integer replaceElement = arr2.higherKey(prev);
            if(replaceElement != null) {
                arr2.put(replaceElement, arr2.get(replaceElement) - 1);
                if(arr2.get(replaceElement) == 0) arr2.remove(replaceElement);

                replace = solve(index1 + 1, replaceElement, arr1, arr2);
                if(replace != Integer.MAX_VALUE) replace++;

                arr2.put(replaceElement, arr2.getOrDefault(replaceElement, 0) + 1);
            }
        }

        int res = Math.min(keep, replace);
        memo.put(key, res);
        return res;
    }
}