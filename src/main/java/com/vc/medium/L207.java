package com.vc.medium;

import java.util.*;

class L207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites == null || prerequisites.length == 0) return true;

        HashMap<Integer, Integer> indegree = new HashMap<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pre: prerequisites) {
            indegree.put(pre[1], indegree.getOrDefault(pre[1], 0) + 1);
            List<Integer> list = map.getOrDefault(pre[0], new ArrayList<Integer>());
            list.add(pre[1]);
            map.put(pre[0], list);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(!indegree.containsKey(i)) q.offer(i);
        }

        while(!q.isEmpty()) {
            int course = q.poll();
            if(!map.containsKey(course)) continue;

            for(Integer release: map.get(course)) {
                indegree.put(release, indegree.get(release) - 1);
                if(indegree.get(release) == 0) {
                    indegree.remove(release);
                    q.offer(release);
                }
            }
        }
        return indegree.size() == 0;
    }
}
