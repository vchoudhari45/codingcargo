package com.vc.medium;

import java.util.*;

class L737 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;

        HashMap<String, HashSet<String>> map = new HashMap<>();
        for(List<String> pair: pairs) {
            String from = pair.get(0);
            String to = pair.get(1);

            HashSet<String> fromSet = map.getOrDefault(from, new HashSet<String>());
            fromSet.add(to);

            HashSet<String> toSet = map.getOrDefault(to, new HashSet<String>());
            toSet.add(from);

            map.put(from, fromSet);
            map.put(to, toSet);
        }
        for(int i = 0; i < words1.length; i++) {
            if(!isSimilar(words1[i], words2[i], map, new HashSet<String>())) return false;
        }
        return true;
    }

    private boolean isSimilar(String s1, String s2,
                              HashMap<String, HashSet<String>> map, HashSet<String> visited) {
        if((map.containsKey(s1) && map.get(s1).contains(s2)) || s1.equals(s2)) return true;
        if(visited.contains(s1)) return false;

        visited.add(s1);
        if(map.containsKey(s1)) {
            for(String s : map.get(s1)) {
                if(isSimilar(s, s2, map, visited)) return true;
            }
        }
        return false;
    }
}
