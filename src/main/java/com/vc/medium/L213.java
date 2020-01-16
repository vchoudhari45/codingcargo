package com.vc.medium;

class L213 {
    public int rob(int[] arr) {
        if(arr.length == 1) return arr[0];
        return Math.max(rob(arr, 0, arr.length - 2), rob(arr, 1, arr.length - 1));
    }

    private int rob(int[] arr, int from, int to) {
        int include = 0;
        int exclude = 0;
        for(int i = from; i <= to; i++) {
            int oldInclude = include;
            include = exclude + arr[i];
            exclude = Math.max(oldInclude, exclude);
        }
        return Math.max(include, exclude);
    }
}
