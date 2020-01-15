package com.vc.medium;

import java.util.*;

class L567 {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 > len2) return false;

        for(int i = 0; i < len1; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }
        //System.out.println(map);
        if(isEmpty(map)) return true;

        for(int i = len1; i < len2; i++) {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
            map.put(s2.charAt(i - len1), map.getOrDefault(s2.charAt(i - len1), 0) + 1);
            if(isEmpty(map)) return true;
        }
        return isEmpty(map);
    }

    private boolean isEmpty(HashMap<Character, Integer> map) {
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() != 0) return false;
        }
        return true;
    }
}
