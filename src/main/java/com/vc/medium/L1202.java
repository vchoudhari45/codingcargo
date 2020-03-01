package com.vc.medium;

import java.util.*;

class L1202 {

    private int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();

        this.parent = new int[n];
        for(int i = 0; i < parent.length; i++) parent[i] = i;

        for(List<Integer> pair: pairs) {
            int fromParent = find(pair.get(0));
            int toParent = find(pair.get(1));
            parent[fromParent] = toParent;
        }

        //Compress Path
        for(int i = 0; i < parent.length; i++) parent[i] = find(parent[i]);

        //Group together characters from same swap group
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap();
        for(int i = 0; i < n; i++) {
            int p = parent[i];
            PriorityQueue<Character> pq = map.getOrDefault(p, new PriorityQueue<Character>());
            pq.offer(s.charAt(i));
            map.put(p, pq);
        }


        //Take minimum character from each swap group
        char[] res = new char[n];
        for(int i = 0; i < n; i++) {
            int p = parent[i];
            res[i] = map.get(p).poll();
        }

        return new String(res);
    }

    private int find(int p) {
        if(parent[p] == p) return p;
        else return find(parent[p]);
    }
}
