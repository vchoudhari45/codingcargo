package com.vc.easy;

import java.util.HashMap;

class L242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(map.getOrDefault(ch, 0) == 0) return false;
            map.put(ch, map.get(ch) - 1);
            if(map.get(ch) == 0) map.remove(ch);
        }

        return map.size() == 0;
    }
}
