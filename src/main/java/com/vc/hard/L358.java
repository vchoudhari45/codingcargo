package com.vc.hard;

import java.util.*;

class Solution {
    class Entry {
        Character ch;
        Integer count;

        Entry(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public String toString() {
            return ch+" -> "+count;
        }
    }

    public String rearrangeString(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> {
            return b.count - a.count;
        });
        for(Map.Entry<Character, Integer> entry: freq.entrySet()) {
            pq.offer(new Entry(entry.getKey(), entry.getValue()));
        }

        //System.out.println(pq);
        StringBuilder str = new StringBuilder();
        Queue<Entry> q = new LinkedList<>();
        while(!pq.isEmpty()) {
            Entry e = pq.poll();
            str.append(e.ch);
            q.offer(new Entry(e.ch, e.count - 1));
            if(q.size() >= k) {
                Entry eNew = q.poll();
                if(eNew.count > 0) pq.offer(eNew);
            }
        }
        return str.length() == s.length() ? str.toString() : "";
    }
}