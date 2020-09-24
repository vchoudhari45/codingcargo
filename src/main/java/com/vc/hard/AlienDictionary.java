package com.vc.hard;

import java.util.*;

class AlienDictionary {
    public String alienOrder(String[] words) {
        /**
             wrt
             wrf
             er
             ett
             rftt

             Building Ingress & Dependency Map
             w -> 0
             r -> 1
             t -> 1
             f -> 1
             e -> 1

             t -> f
             w -> e
             r -> t
             e -> r

             Topological Sorting
             wertf
        */

        HashMap<Character, Integer> ingress = new HashMap<>();
        HashMap<Character, HashSet<Character>> dependencyMap = new HashMap<>();
        for(String word: words) {
            for(int i = 0; i < word.length(); i++) ingress.put(word.charAt(i), 0);
        }

        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            boolean found = false;
            for(int index = 0; index < Math.min(word1.length(), word2.length()); index++) {
                char ch1 = word1.charAt(index);
                char ch2 = word2.charAt(index);
                if(ch1 != ch2) {
                    HashSet<Character> set = dependencyMap.getOrDefault(ch1, new HashSet<>());
                    if(!set.contains(ch2)) {
                        set.add(ch2);
                        ingress.put(ch2, ingress.getOrDefault(ch2, 0) + 1);
                        dependencyMap.put(ch1, set);
                    }
                    found = true;
                    break;
                }
            }
            if(!found && word1.length() > word2.length()) return "";
        }

        Queue<Character> q = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry: ingress.entrySet()) {
            if(entry.getValue() == 0) q.offer(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            char ch = q.poll();
            sb.append(ch);
            if(dependencyMap.containsKey(ch)) {
                for(Character dependantCh: dependencyMap.get(ch)) {
                    ingress.put(dependantCh, ingress.getOrDefault(dependantCh, 0) - 1);
                    if(ingress.get(dependantCh) == 0) q.offer(dependantCh);
                }
            }
        }

        return ingress.size() == sb.length() ? sb.toString() : "";
    }
}