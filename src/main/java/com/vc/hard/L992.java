package com.vc.hard;

import java.util.HashMap;

class L992 {
    public int subarraysWithKDistinct(int[] arr, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int end = 0, start = 0, res = 0, prefix = 0, n = arr.length;
        while(end < n) {
            int num = arr[end];

            map.put(num, map.getOrDefault(num, 0) + 1);

            while(map.size() > K) {
                //Remove start & all it's prefix it cause size > K
                prefix = 0;
                int oldStart = start;
                start += map.get(arr[start]);
                map.remove(arr[oldStart]);
            }

            while(map.getOrDefault(arr[start], 0) > 1) {
                //If current element is same as element in the prefix,
                //Add it to prefix count
                map.put(arr[start], map.get(arr[start++]) - 1);
                prefix++;
            }

            if(map.size() == K) res += prefix + 1;

            end++;
        }
        return res;
    }
}
