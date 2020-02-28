package com.vc.medium;

import java.util.*;

class L398 {

    private Random random;
    private HashMap<Integer, List<Integer>> map;

    public L398(int[] nums) {
        this.map = new HashMap<>();
        this.random = new Random();

        for(int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<Integer>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int rIndex = random.nextInt(list.size());
        return list.get(rIndex);
    }
}
