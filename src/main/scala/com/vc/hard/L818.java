package com.vc.hard;

import java.util.*;

class L818 {
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{0, 1}); //position, speed

        int level = 0;
        HashSet<String> visited = new HashSet<String>();
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] state = q.poll();
                String key = state[0] +" "+ state[1];
                if(state[0] == target) return level;
                if(!visited.contains(key) && 0 < state[0] + state[1] && state[0] + state[1] < (target << 1)) {
                    //forward
                    q.offer(new int[] {state[0] + state[1], state[1] * 2});
                }

                if(!visited.contains(key)) {
                    //backward
                    q.offer(new int[] {state[0], state[1] > 0 ? -1 : 1});
                }
                visited.add(key);
            }
            level++;
        }
        return level;
    }
}
