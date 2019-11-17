package com.vc.hard;

import java.util.*;

class L699 {
    public List<Integer> fallingSquares(int[][] positions) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(0, 0);
        int maxHeight = 0;
        List<Integer> list = new ArrayList<Integer>();
        for(int[] pos: positions) {
            int start = pos[0];
            int end = start + pos[1];
            int from = map.floorKey(start);
            int height = map.subMap(from, end).values().stream().max(Integer::compare).orElse(0) + pos[1];

            maxHeight = Math.max(height, maxHeight);
            list.add(maxHeight);
            int lastHeight = map.floorEntry(end).getValue();

            map.put(start, height);
            map.put(end, lastHeight);

            Map<Integer, Integer> subMap = map.subMap(start, false, end, false);
            map.keySet().removeAll(new HashSet<Integer>(subMap.keySet()));
        }
        return list;
    }
}