package com.vc.medium;

import java.util.*;

class L659 {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> next = new HashMap<>();
        for(Integer num: nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        for(Integer num: nums) {
            if(freq.get(num) == 0) continue;
            else if(next.containsKey(num) && next.get(num) > 0) {
                next.put(num, next.getOrDefault(num, 0) - 1);
                next.put(num + 1, next.getOrDefault(num + 1, 0) + 1);
            }
            else if(freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                freq.put(num + 1, freq.getOrDefault(num + 1, 0) - 1);
                freq.put(num + 2, freq.getOrDefault(num + 2, 0) - 1);
                next.put(num + 3, next.getOrDefault(num + 3, 0) + 1);
            }
            else return false;
            freq.put(num, freq.get(num) - 1);
        }
        return true;
    }
}