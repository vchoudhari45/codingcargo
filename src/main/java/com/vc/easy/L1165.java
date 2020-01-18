package com.vc.easy;

import java.util.*;

class L1165 {
    public int calculateTime(String keyboard, String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }

        int res = 0;
        int prev = 0;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            res += Math.abs(map.get(ch) - prev);
            prev = map.get(ch);
        }
        return res;
    }
}
