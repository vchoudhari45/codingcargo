package com.vc.medium;

import java.util.HashMap;

class L159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, res = 0, n = s.length(), k = 2;
        while(end < n) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(start < s.length() && map.size() > k) {
                char toBeRemoved = s.charAt(start++);
                map.put(toBeRemoved, map.getOrDefault(toBeRemoved, 0) - 1);
                if(map.get(toBeRemoved) <= 0) map.remove(toBeRemoved);
            }
            if(map.size() <= k) res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
