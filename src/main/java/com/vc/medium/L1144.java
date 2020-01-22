package com.vc.medium;

class L1144 {
    public int movesToMakeZigzag(int[] arr) {
        int odd = 0;
        int even = 0;
        for(int i = 0; i < arr.length; i++) {
            int prev = i == 0 ? Integer.MAX_VALUE : arr[i - 1];
            int next = i + 1 < arr.length ? arr[i + 1] : Integer.MAX_VALUE;
            int change = Math.max(0, arr[i] - Math.min(prev, next) + 1);
            if(i % 2 == 0) even += change;
            else odd += change;
        }
        return Math.min(odd, even);
    }
}
