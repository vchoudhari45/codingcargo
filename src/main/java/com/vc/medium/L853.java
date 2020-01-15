package com.vc.medium;

import java.util.*;

class L853 {
    public int carFleet(int target, int[] positions, int[] speeds) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < positions.length; i++) {
            int p = positions[i];
            int s = speeds[i];
            map.put(target - p, s);
        }

        int res = 0;
        double prevTime = -1.0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int distance = entry.getKey();
            int speed = entry.getValue();
            double time = (double)distance / (double)speed;
            if(prevTime < time) {
                prevTime = time;
                res++;
            }
        }
        return res;
    }
}
