package com.vc.medium;

class L11 {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max = 0;
        while(lo < hi) {
            max = Math.max(max, (hi - lo) * Math.min(height[lo], height[hi]));
            if(height[lo] < height[hi]) lo++;
            else hi--;
        }
        return max;
    }
}
