package com.vc.hard;

import java.util.*;

class L403 {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0) return true;

        int n = stones.length;

        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int stone: stones) map.put(stone, new HashSet<>());
        map.get(0).add(0);

        for(int i = 0; i < stones.length; i++) {
            for(Integer prevjump: map.get(stones[i])) { //what jump lands me on this stone
                for(int nextjump = prevjump - 1; nextjump <= prevjump + 1; nextjump++) {
                    if(nextjump > 0 && map.containsKey(stones[i] + nextjump))
                        map.get(stones[i] + nextjump).add(nextjump);
                }
            }
        }
        //System.out.println(map);
        return map.get(stones[n - 1]).size() > 0;
    }
}