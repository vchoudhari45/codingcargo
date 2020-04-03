package com.vc.medium;

import java.util.*;

class L743 {
    class ToNode {
        int node;
        int time;

        ToNode(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public String toString() {
            return node+" "+time;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, Integer> dist = new HashMap<>();
        for(int i = 1; i <= N; i++) dist.put(i, Integer.MAX_VALUE);
        dist.put(K, 0);

        HashMap<Integer, List<ToNode>> map = new HashMap<>();
        for(int[] time: times) {
            int from = time[0];
            int to = time[1];
            int timeTaken = time[2];
            List<ToNode> fromList = map.getOrDefault(from, new ArrayList<>());
            fromList.add(new ToNode(to, timeTaken));
            map.put(from, fromList);
        }
        //System.out.println(map);

        Queue<Integer> q = new LinkedList<>();
        q.offer(K);
        while(!q.isEmpty()) {
            int node = q.poll();
            if(!map.containsKey(node)) continue;
            for(ToNode nei: map.get(node)) {
                int time = nei.time;
                int toNode = nei.node;
                if(dist.get(toNode) == -1 || dist.get(toNode) > dist.get(node) + time) {
                    dist.put(toNode, dist.get(node) + time);
                    q.offer(toNode);
                }
            }
        }

        int totalTime = 0;
        for(Map.Entry<Integer, Integer> entry: dist.entrySet()) {
            int time = entry.getValue();
            if(time == Integer.MAX_VALUE) return -1;
            totalTime = Math.max(time, totalTime);
        }
        return totalTime;
    }
}
