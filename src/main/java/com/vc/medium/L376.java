package com.vc.medium;

class L376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];

        up[0] = down[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            int from = nums[i - 1];
            int to = nums[i];

            if(from > to) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            }
            else if(from < to) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            }
            else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
}
