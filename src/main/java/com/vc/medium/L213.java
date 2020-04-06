package com.vc.medium;

class L213 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int robFirst = rob(nums, 0, nums.length - 2);
        int robLast = rob(nums, 1, nums.length - 1);
        return Math.max(robFirst, robLast);
    }

    private int rob(int[] nums, int from, int to) {
        int prevToPrevHouse = 0, prevHouse = 0, currentHouse = 0;
        for(int i = from; i <= to; i++) {
            currentHouse = Math.max(prevToPrevHouse + nums[i], prevHouse);
            prevToPrevHouse = prevHouse;
            prevHouse = currentHouse;
        }
        return currentHouse;
    }
}
