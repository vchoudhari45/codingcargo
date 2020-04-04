package com.vc.hard;

import java.util.*;

class L1136 {
    public int minimumSemesters(int N, int[][] relations) {
        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 1; i <= N; i++) indegree.put(i, 0);

        for(int[] relation: relations) {
            int from = relation[0];
            int to = relation[1];

            indegree.put(to, indegree.get(to) + 1);
            List<Integer> list = map.getOrDefault(from, new ArrayList<>());
            list.add(to);
            map.put(from, list);
        }

        //System.out.println(indegree);
        //System.out.println(map);

        int semester = 0;
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            if(entry.getValue() == 0) {
                q.offer(entry.getKey());
                N--;
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int course = q.poll();
                if(!map.containsKey(course)) continue;
                for(int courseAfter: map.get(course)) {
                    indegree.put(courseAfter, indegree.getOrDefault(courseAfter, 0) - 1);
                    if(indegree.get(courseAfter) == 0) {
                        q.offer(courseAfter);
                        N--;
                    }
                }
            }
            semester++;
        }

        return N == 0 ? semester : -1;
    }
}
