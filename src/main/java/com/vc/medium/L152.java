package com.vc.medium;

class L152 {
    public int maxProduct(int[] arr) {
        if(arr == null || arr.length == 0) return 0;

        int n = arr.length, max = 0;
        int[] maxValue = new int[n];
        int[] minValue = new int[n];
        maxValue[0] = arr[0];
        minValue[0] = arr[0];
        max = Math.max(maxValue[0], minValue[0]);
        for(int i = 1; i < n; i++) {
            if(arr[i] < 0) {
                maxValue[i] = Math.max(minValue[i - 1] * arr[i], arr[i]);
                minValue[i] = Math.min(maxValue[i - 1] * arr[i], arr[i]);
            }
            else {
                maxValue[i] = Math.max(maxValue[i - 1] * arr[i], arr[i]);
                minValue[i] = Math.min(minValue[i - 1] * arr[i], arr[i]);
            }
            max = Math.max(maxValue[i], max);
        }
        return max;
    }
}
