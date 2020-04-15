package com.vc.easy;

import java.util.*;

class L266 {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        boolean foundOne = false;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                if(foundOne) return false;
                else foundOne = true;
            }
        }
        return true;
    }
}
