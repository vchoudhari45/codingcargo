package com.vc.medium;

import java.util.*;

class L444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        for(List<Integer> seq: seqs) {
            for(Integer s: seq) {
                map.putIfAbsent(s, new HashSet<>());
                indegree.putIfAbsent(s, 0);
            }
        }

        for(List<Integer> seq: seqs) {
            if(seq.size() == 1) continue;
            for(int i = 1; i < seq.size(); i++) {
                int prev = seq.get(i - 1);
                int next = seq.get(i);
                if(map.get(prev).add(next)) {
                    indegree.put(next, indegree.getOrDefault(next, 0) + 1);
                }
            }
        }

        if(org.length != indegree.size()) return false; //it means there can be multiple seq possible

        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            if(entry.getValue() == 0) q.offer(entry.getKey());
        }

        int count = 0;
        while(q.size() == 1) {
            int e = q.poll();
            for(int next: map.get(e)) {
                indegree.put(next, indegree.getOrDefault(next, 0) - 1);
                if(indegree.get(next) == 0) q.offer(next);
            }
            count++;
        }
        return count == indegree.size();
    }
}
