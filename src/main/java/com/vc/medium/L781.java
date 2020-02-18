package com.vc.medium;

import java.util.*;

class L781 {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int ans: answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        int total = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int ans = entry.getKey();
            int count = entry.getValue();
            int groups = count / (ans + 1);

            if(count % (ans + 1) != 0) {
                //All the rabbits in the group were not asked that question
                total += (groups + 1) * (ans + 1);
            }
            else total += groups * (ans + 1);
        }
        return total;
    }
}
