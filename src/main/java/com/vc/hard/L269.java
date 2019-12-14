package com.vc.hard;

import java.util.*;

class L269 {
    public String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        HashMap<Character, Integer> ingress = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) ingress.put(words[i].charAt(j), 0);
        }

        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int len = Math.min(word1.length(), word2.length());
            for(int j = 0; j < len; j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);

                if(ch1 != ch2) {
                    HashSet<Character> set = map.getOrDefault(ch1, new HashSet<Character>());
                    if(!set.contains(ch2)) {
                        set.add(ch2);
                        ingress.put(ch2, ingress.get(ch2) + 1);
                        map.put(ch1, set);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        /**
         za
         zb
         ca
         cb

         z -> c
         a -> b

         z
         x
         z
         */
        //System.out.println(map);
        //System.out.println(ingress);

        for(Map.Entry<Character, Integer> entry: ingress.entrySet()) {
            if(entry.getValue() == 0) q.offer(entry.getKey());
        }

        StringBuilder str = new StringBuilder();
        while(!q.isEmpty()) {
            char ch = q.poll();
            str.append(ch);
            if(map.containsKey(ch)) {
                for(Character c: map.get(ch)) {
                    ingress.put(c, ingress.get(c) - 1);
                    if(ingress.get(c) == 0) q.offer(c);
                }
            }
        }

        if(str.length() == ingress.size()) return str.toString();
        else return "";
    }
}
