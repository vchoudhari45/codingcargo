package com.vc.hard;

import java.util.*;

class L514 {
    public int findRotateSteps(String ring, String key) {
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        return solve(ring, key, 0, map);
    }

    private int find(String ring, char ch) {
        int i = ring.length() - 1;
        while(i >= 0) {
            if(ring.charAt(i) == ch) return i;
            i--;
        }
        return i;
    }

    private int solve(String ring, String key, int index,
                      HashMap<String, HashMap<Integer, Integer>> map) {
        if(index == key.length()) return 0;
        char ch = key.charAt(index);

        if(map.containsKey(ring) && map.get(ring).containsKey(index)) return map.get(ring).get(index);

        int forwardMove = ring.indexOf(ch);
        int backwardMove = find(ring, ch);

        int forwardTotal = 1 + forwardMove +
                           solve(ring.substring(forwardMove) + ring.substring(0, forwardMove), key, index + 1, map);

        int backwardTotal = 1 + ring.length() - backwardMove +
                            solve(ring.substring(backwardMove) + ring.substring(0, backwardMove), key, index + 1, map);

        int res = Math.min(forwardTotal, backwardTotal);
        HashMap<Integer, Integer> ringMap = new HashMap<>();
        ringMap.put(index, res);
        map.put(ring, ringMap);
        return res;
    }
}
