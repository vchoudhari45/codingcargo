package com.vc.hard;

import java.util.*;

class L699 {
    public List<Integer> fallingSquares(int[][] positions) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        List<Integer> res = new ArrayList<>();
        int maxHeight = 0;
        for(int i = 0; i < positions.length; i++) {
            int start = positions[i][0];
            int end = positions[i][1] + start;

            int from = map.floorKey(start);
            Map<Integer, Integer> subMap = map.subMap(from, true, end, false);
            int height = 0;
            for(Map.Entry<Integer, Integer> entry: subMap.entrySet()) {
                height = Math.max(height, entry.getValue());
            }
            height += positions[i][1];
            maxHeight = Math.max(maxHeight, height);
            int lastHeight = map.floorEntry(end).getValue();
            res.add(maxHeight);

            map.put(start, height);
            map.put(end, lastHeight);

            subMap = map.subMap(start, false, end, false);
            map.keySet().removeAll(new HashSet<>(subMap.keySet()));
        }
        return res;
    }
}