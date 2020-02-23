package com.vc.medium;

import java.util.HashMap;

class L1358 {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int end = 0, start = 0, res = 0, n = s.length();
        while(end < n) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(start < n && map.size() >= 3) {
                char toBeRemoved = s.charAt(start++);
                map.put(toBeRemoved, map.getOrDefault(toBeRemoved, 0) - 1);
                if(map.get(toBeRemoved) == 0) map.remove(toBeRemoved);
            }
            res += start;
            end++;
        }
        return res;
    }
}

