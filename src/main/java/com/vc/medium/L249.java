package com.vc.medium;

import java.util.*;

class L249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<> ();
        for (String str : strings) {
            String key = getKey(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<List<String>> (map.values());
    }

    private String getKey(String word) {
        StringBuilder sb = new StringBuilder();
        if (word.isEmpty()) return sb.toString();
        char first = word.charAt(0);
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - first;
            if(ch < 0) ch += 26;
            sb.append((char)ch);
        }
        return sb.toString();
    }
}
