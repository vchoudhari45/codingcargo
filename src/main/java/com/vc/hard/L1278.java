package com.vc.hard;

import java.util.HashMap;

class L1278 {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        return partition(s, k, map);
    }

    private int partition(String s, int k, HashMap<String, Integer> map) {
        String key = s + " " + k;
        if(map.containsKey(key)) return map.get(key);
        if(s.equals("")) {
            if(k == 0) return 0;
            else if(k > 0) return Integer.MAX_VALUE;
        }
        if(k <= 0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        int take = (s.length() + 1) / k;
        for(int takeChar = s.length(); takeChar > 0; takeChar--) {
            int res = partition(s.substring(takeChar), k - 1, map);
            if(res != Integer.MAX_VALUE) min = Math.min(min, count(s, 0, takeChar - 1) + res);
        }
        map.put(key, min);
        return min;
    }

    private int count(String s, int start, int end) {
        int res = 0;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) res++;
            start++;
            end--;
        }
        return res;
    }
}
