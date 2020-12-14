package com.vc.hard;

import java.util.*;

class StrangePrinterII {
    public boolean isPrintable(int[][] targetGrid) {

        HashMap<Integer, int[]> rangeMap = new HashMap<>();
        for(int row = 0; row < targetGrid.length; row++) {
            for(int col = 0; col < targetGrid[0].length; col++) {
                if(!rangeMap.containsKey(targetGrid[row][col])) {
                    rangeMap.put(targetGrid[row][col], new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE});
                }

                int[] range = rangeMap.get(targetGrid[row][col]);
                range[0] = Math.min(range[0], row);
                range[1] = Math.max(range[1], row);
                range[2] = Math.min(range[2], col);
                range[3] = Math.max(range[3], col);
            }
        }

        Set<Integer> keys = rangeMap.keySet();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for(Integer key: keys) inDegree.put(key, 0);

        HashMap<Integer, HashSet<Integer>> unlocks = new HashMap<>();
        for(Integer key: keys) {
            unlocks.put(key, new HashSet<>());
            int xMin = rangeMap.get(key)[0];
            int xMax = rangeMap.get(key)[1];
            int yMin = rangeMap.get(key)[2];
            int yMax = rangeMap.get(key)[3];
            for(int row = xMin; row <= xMax; row++) {
                for(int col = yMin; col <= yMax; col++) {
                    if(targetGrid[row][col] != key && !unlocks.get(key).contains(targetGrid[row][col])) {
                        inDegree.put(targetGrid[row][col], inDegree.get(targetGrid[row][col]) + 1);
                        HashSet<Integer> dep = unlocks.getOrDefault(key, new HashSet<>());
                        dep.add(targetGrid[row][col]);
                        unlocks.put(key, dep);
                    }
                }
            }
        }

        Queue<Integer> q = new LinkedList();
        int size = 0;
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                q.offer(entry.getKey());
                size++;
            }
        }

        while(!q.isEmpty()) {
            int element = q.poll();
            if(unlocks.containsKey(element)) {
                HashSet<Integer> unlock = unlocks.get(element);
                for(Integer gettingUnlocked: unlock) {
                    inDegree.put(gettingUnlocked, inDegree.getOrDefault(gettingUnlocked, 0) - 1);
                    if(inDegree.get(gettingUnlocked) == 0) {
                        q.offer(gettingUnlocked);
                        size++;
                    }
                }
            }
        }

        return rangeMap.size() == size;
    }
}