package com.vc.hard;

import java.util.*;

class L1316 {
    public int distinctEchoSubstrings(String text) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            List<Integer> list = map.getOrDefault(ch, new ArrayList<Integer>());
            list.add(i);
            map.put(ch, list);
        }

        HashSet<String> set = new HashSet<>();
        for(Map.Entry<Character, List<Integer>> entry: map.entrySet()) {
            char ch = entry.getKey();
            List<Integer> list = entry.getValue();
            for(int i = 0; i < list.size(); i++) {
                for(int j = i + 1; j < list.size(); j++) {
                    int current = list.get(j);
                    int prev = list.get(i);

                    int len = current - prev;

                    String ps = text.substring(prev, current);
                    String cs = current + len <= text.length() ?
                            text.substring(current, current + len) : "";

                    if(ps.equals(cs)) set.add(text.substring(prev, current));
                }
            }
        }
        return set.size();
    }
}
