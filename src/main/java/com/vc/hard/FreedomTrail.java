package com.vc.hard;

import java.util.*;

class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        int rLength = ring.length();
        int kLength = key.length();

        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < rLength; i++) {
            char ch = ring.charAt(i);
            List<Integer> list = map.getOrDefault(ch, new ArrayList<>());
            list.add(i);
            map.put(ch, list);
        }

        char firstChar = key.charAt(0);
        TreeMap<Integer, Integer> prevMap = new TreeMap<>();
        for(Integer index: map.getOrDefault(firstChar, new ArrayList<>())) {
            prevMap.put(index, 1 + Math.min(index, rLength - index));
        }

        for(int i = 1; i < kLength; i++) {
            char current = key.charAt(i);

            TreeMap<Integer, Integer> currentMap = new TreeMap<>();
            for(Integer index: map.getOrDefault(current, new ArrayList<>())) {
                Integer left = prevMap.floorKey(index);
                Integer right = prevMap.ceilingKey(index);

                if(left == null) left = prevMap.lastKey();
                if(right == null) right = prevMap.firstKey();

                //Anti-clock moves
                int anti = left <= index ? index - left : rLength + index - left;
                anti += prevMap.get(left);

                //Clockwise moves
                int clock = right >= index ? right - index : rLength - index + right;
                clock += prevMap.get(right);

                currentMap.put(index, Math.min(anti, clock) + 1);
            }
            prevMap = currentMap;
        }

        int res = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry: prevMap.entrySet()) {
            res = Math.min(res, entry.getValue());
        }
        return res;
    }
}