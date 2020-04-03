package com.vc.medium;

import java.util.*;

class L841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()) {
            int room = q.poll();

            if(visited.contains(room)) continue;

            visited.add(room);
            for(int keys: rooms.get(room)) q.offer(keys);
        }
        return visited.size() == rooms.size();
    }
}
