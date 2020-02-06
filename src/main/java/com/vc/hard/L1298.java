package com.vc.hard;

import java.util.*;

class L1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        HashSet<Integer> boxFound = new HashSet<>();
        HashSet<Integer> keyFound = new HashSet<>();
        HashSet<Integer> boxUsed = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        for(Integer box: initialBoxes) {
            if(status[box] == 1) {
                boxFound.add(box);
                keyFound.add(box);
                q.offer(box);
            }
            else boxFound.add(box);
        }

        int total = 0;
        while(!q.isEmpty()) {
            int box = q.poll();
            if(!boxUsed.contains(box)) {
                boxUsed.add(box);
                total += candies[box];

                //We found key, if Box was also found then you can add it into queue
                for(Integer key: keys[box]) {
                    keyFound.add(key);
                    if(boxFound.contains(key)) q.offer(key);
                }

                //We found box, if box is open or key was already found add it into queue
                for(Integer insideBox: containedBoxes[box]) {
                    boxFound.add(insideBox);
                    if(keyFound.contains(insideBox) || status[insideBox] == 1) q.offer(insideBox);
                }
            }
        }
        return total;
    }
}
