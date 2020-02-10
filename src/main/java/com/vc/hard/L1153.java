package com.vc.hard;

import java.util.*;

class L1153 {
    public boolean canConvert(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        if(n1 != n2) return false;
        if(str1.equals(str2)) return true;

        /**
            "abcdefghijklmnopqrstuvwxyz"
            "bcdefghijklmnopqrstuvwxyza"
         */
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < n1; i++) set.add(str2.charAt(i));
        if(set.size() >= 26) return false;

        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < n1; i++) {
            char ch1 = str1.charAt(i), ch2 = str2.charAt(i);
            if(map.containsKey(ch1) && map.get(ch1) != ch2) return false;
            map.put(ch1, ch2);
        }
        return true;
    }
}
