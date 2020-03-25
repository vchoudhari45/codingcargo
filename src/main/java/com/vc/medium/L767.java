package com.vc.medium;

import java.util.*;

class L767 {
    static class Entry {
        char ch;
        int count;

        Entry(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public String toString() {
            return ch+" "+count;
        }
    }

    public String reorganizeString(String s) {
        PriorityQueue<Entry> pq = new PriorityQueue<>(new Comparator<Entry>(){
            public int compare(Entry e1, Entry e2) {
                return Integer.compare(e2.count, e1.count);
            }
        });

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.offer(new Entry(entry.getKey(), entry.getValue()));
        }

        Queue<Entry> q = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()) {
            Entry e = pq.poll();
            str.append(e.ch);
            q.offer(new Entry(e.ch, e.count - 1));
            if(q.size() > 1) {
                Entry eNew = q.poll();
                if(eNew.count > 0) pq.offer(eNew);
            }
        }
        return str.length() == s.length() ? str.toString() : "";
    }
}