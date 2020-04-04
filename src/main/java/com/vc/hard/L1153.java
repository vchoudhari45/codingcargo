package com.vc.hard;

import java.util.*;

class L1153 {
    public boolean canConvert(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        if(n1 != n2) return false;

        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < n1; i++) {
            char ch1 = str1.charAt(i), ch2 = str2.charAt(i);
            set.add(ch2);
            if(map.containsKey(ch1) && map.get(ch1) != ch2) return false;
            map.put(ch1, ch2);
        }
        return set.size() < 26 || str1.equals(str2);
    }
}
