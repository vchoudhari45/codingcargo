package com.vc.easy;

class L198 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int currentHouse = 0, prevHouse = 0, prevToPrevHouse = 0;
        for(int i = 0; i < nums.length; i++) {
            currentHouse = Math.max(prevToPrevHouse + nums[i], prevHouse);
            prevToPrevHouse = prevHouse;
            prevHouse = currentHouse;
        }
        return currentHouse;
    }
}
