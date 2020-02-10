package com.vc.hard;

import java.util.TreeMap;

class L975 {
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = arr.length;
        boolean[] lower = new boolean[n];
        boolean[] higher = new boolean[n];

        lower[n - 1] = higher[n - 1] = true;
        map.put(arr[ n - 1], n - 1);

        int res = 1;
        for(int i = n - 2; i >= 0; i--){
            Integer lo = map.floorKey(arr[i]);
            Integer hi = map.ceilingKey(arr[i]);

            if(lo != null) lower[i] = higher[map.get(lo)];
            if(hi != null) higher[i] = lower[map.get(hi)];

            if(higher[i]) res++;

            map.put(arr[i], i);
        }
        return res;
    }
}
