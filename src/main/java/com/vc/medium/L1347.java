package com.vc.medium;

import java.util.*;

class L1347 {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            }
        }

        int res = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            int count = entry.getValue();
            if(count > 0) res += count;
        }
        return res;
    }
}
