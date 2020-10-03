package com.vc.hard;

import java.util.*;

class RearrangeStringKDistanceApart {
    static class Entry {
        char ch;
        int count;

        Entry(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    public String rearrangeString(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Entry> pq = new PriorityQueue<Entry>(new Comparator<Entry>(){
            public int compare(Entry e1, Entry e2) {
                int cmp = Integer.compare(e2.count, e1.count);
                if(cmp == 0) return e1.ch - e2.ch;
                else return cmp;
            }
        });

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            pq.offer(new Entry(ch, count));
        }

        StringBuilder st = new StringBuilder();
        Queue<Entry> q = new LinkedList<>();
        while(!pq.isEmpty()) {
            Entry e = pq.poll();
            st.append(e.ch);
            q.offer(new Entry(e.ch, e.count - 1));
            if(q.size() >= k) {
                Entry eNew = q.poll();
                if(eNew.count > 0) pq.offer(eNew);
            }
        }
        return st.length() == s.length() ? st.toString() : "";
    }
}