package com.vc.medium;

class L477 {
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j = 0; j < 32; j++) {
            int k = 0; //Let assume k number have jth bit set, so (n - k) numbers don't have jth bit set
            for (int i = 0; i < n; i++) k += (nums[i] >> j) & 1;
            total += k * (n - k); //total will be k * (n - k)
        }
        return total;
    }
}
