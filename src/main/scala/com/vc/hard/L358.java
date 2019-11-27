package com.vc.hard;

import java.util.*;

class L358 {
    public String rearrangeString(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry: freq.entrySet()) {
            pq.offer(entry);
        }

        Queue<Map.Entry<Character, Integer>> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()) {
            //System.out.println("pq: "+pq+" q: "+q);
            Map.Entry<Character, Integer> e = pq.poll();
            str.append(e.getKey());
            Map.Entry<Character, Integer> eNew = new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue() - 1);
            q.offer(eNew);
            if(q.size() >= k) {
                Map.Entry<Character, Integer> eFromQ = q.poll();
                if(eFromQ.getValue() > 0) pq.offer(eFromQ);
            }
        }
        return str.length() == s.length() ? str.toString() : "";
    }
}
