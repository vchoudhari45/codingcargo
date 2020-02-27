package com.vc.medium;

import java.util.*;

class L791 {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(map.containsKey(ch)) {
                for(int j = 0; j < map.get(ch); j++) str.append(ch);
                map.remove(ch);
            }
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) str.append(entry.getKey());
        }
        return str.toString();
    }
}
