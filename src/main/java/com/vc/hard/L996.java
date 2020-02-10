package com.vc.hard;

import java.util.*;

class L996 {
    int count = 0;
    public int numSquarefulPerms(int[] arr) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int from = arr[i];
                int to = arr[j];

                double sqrt = Math.sqrt(from + to);
                if(sqrt == Math.ceil(sqrt)) {
                    HashSet<Integer> fromList = map.getOrDefault(from, new HashSet<Integer>());
                    fromList.add(to);

                    HashSet<Integer> toList = map.getOrDefault(to, new HashSet<Integer>());
                    toList.add(from);

                    map.put(from, fromList);
                    map.put(to, toList);
                }
            }
        }

        //System.out.println(map);

        //{1=[8], 17=[8], 8=[1, 17]}
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }

        for(Integer from: countMap.keySet()) {
            solve(from, arr.length - 1, map, countMap);
        }
        return count;
    }

    private void solve(int from, int remaining,
                       HashMap<Integer, HashSet<Integer>> map, HashMap<Integer, Integer> countMap) {
        if(countMap.getOrDefault(from, 0) <= 0) return;

        if(remaining == 0) count++;

        //System.out.println(from);
        countMap.put(from, countMap.get(from) - 1);
        if(map.containsKey(from)) {
            for(Integer to: map.get(from)) {
                solve(to, remaining - 1, map, countMap);
            }
        }
        countMap.put(from, countMap.get(from) + 1);
    }
}
