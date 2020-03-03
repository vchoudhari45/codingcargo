package com.vc.medium;

import java.util.*;

class L621 {

    static class Task {
        char ch;
        int count;

        Task(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>(){
            public int compare(Task t1, Task t2) {
                return Integer.compare(t2.count, t1.count);
            }
        });

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.offer(new Task(entry.getKey(), entry.getValue()));
        }

        Queue<Task> q = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty()) {
            int intervals = 0;
            while(intervals <= n) {
                if(pq.isEmpty() && q.isEmpty()) return time;

                if(!pq.isEmpty()) {
                    Task t = pq.poll();
                    if(--t.count > 0) q.offer(t);
                }
                time++;
                intervals++;
            }

            while(!q.isEmpty()) pq.offer(q.poll());
        }
        return time;
    }
}
