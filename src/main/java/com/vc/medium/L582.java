package com.vc.medium;

import java.util.*;

class L582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if(kill == 0) return pid;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);
            List<Integer> list = map.getOrDefault(parent, new ArrayList<>());
            list.add(child);
            map.put(parent, list);
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(kill);
        while(!q.isEmpty()) {
            int process = q.poll();
            res.add(process);
            if(map.containsKey(process)) {
                q.addAll(map.get(process));
            }
        }
        return res;
    }
}
