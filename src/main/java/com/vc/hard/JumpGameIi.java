package com.vc.hard;

class JumpGameIi {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;

        int jumps = 0, farthestWithMinimumJump = 0, farthestAtIndex = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            farthestAtIndex = Math.max(farthestAtIndex, i + nums[i]);
            if(i >= farthestWithMinimumJump) {
                farthestWithMinimumJump = farthestAtIndex;
                jumps++;
            }
        }
        return jumps;
    }
}
