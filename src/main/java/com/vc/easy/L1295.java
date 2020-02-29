package com.vc.easy;

class L1295 {
    public int findNumbers(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            int digits = countDigits(nums[i]);
            if(digits % 2 == 0) res++;
        }
        return res;
    }

    private int countDigits(int num) {
        int res = 0;
        while(num > 0) {
            num = num / 10;
            res++;
        }
        return res;
    }
}
