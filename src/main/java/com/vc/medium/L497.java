package com.vc.medium;

import java.util.*;

class L497 {

    int[][] rects;
    Random r;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int sum = 0;

    public L497(int[][] rects) {
        this.rects = rects;
        sum = 0;
        for(int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            int left = r[0];
            int bottom = r[1];
            int right = r[2];
            int top = r[3];

            sum += (right - left + 1) * (top - bottom + 1);
            map.put(sum, i);
        }
        r = new Random();
    }

    public int[] pick() {
        int randomArea = r.nextInt(sum + 1);
        int pickedArea = map.ceilingKey(randomArea);
        int index = map.get(pickedArea);

        int[] rect = rects[index];

        int left = rect[0];
        int bottom = rect[1];
        int right = rect[2];
        int top = rect[3];

        int x = left + r.nextInt(right - left + 1);
        int y = bottom + r.nextInt(top - bottom + 1);

        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */