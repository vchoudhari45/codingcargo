package com.vc.hard;

import java.util.*;

class L1224 {
    public int maxEqualFreq(int[] arr) {
        //https://leetcode.com/problems/maximum-equal-frequency/discuss/403931/JavaC%2B%2BPython-Easy-to-understand-(compare-counts)
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        int res = 1;
        for(int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
            int freq = countMap.get(arr[i]);
            freqMap.put(freq, freqMap.getOrDefault(freq, 0) + 1);

            //System.out.println("arr[i]: "+arr[i]+" Res: "+res+" freq: "+freq+" countMap: "+countMap+" freqMap: "+freqMap);
            if(freq * freqMap.get(freq) == i + 1 && i != arr.length - 1) {
                //Case 1: [2, 2, 1] and index i at 1
                res = Math.max(res, i + 2);
            }
            else if(freq * freqMap.get(freq) == i) {
                // Case 2: [2, 2, 2, 1, 1] and index i at 4
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }
}
