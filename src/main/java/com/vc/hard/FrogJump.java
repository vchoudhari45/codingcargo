package com.vc.hard;

import java.util.*;

class FrogJump {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0) return true;

        int n = stones.length;

        HashMap<Integer, Set<Integer>> stonesMap = new HashMap<>();
        for(int stone: stones) stonesMap.put(stone, new HashSet<>());
        stonesMap.get(0).add(0);

        for(int i = 0; i < n; i++) {
            for(int jump: stonesMap.get(stones[i])) { //Jump that lands me on this stone
                //try jump + 1 from current stone
                if(stonesMap.containsKey(stones[i] + jump + 1)) {
                    stonesMap.get(stones[i] + jump + 1).add(jump + 1);
                }

                //try jump from current stone
                if(stonesMap.containsKey(stones[i] + jump)) {
                    stonesMap.get(stones[i] + jump).add(jump);
                }

                //try jump - 1 from current stone
                if(jump - 1 > 0 && stonesMap.containsKey(stones[i] + jump - 1)) {
                    stonesMap.get(stones[i] + jump - 1).add(jump - 1);
                }
            }
        }

        return stonesMap.get(stones[n - 1]).size() > 0;
    }
}