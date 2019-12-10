package com.vc.hard;

class L164 {
    public int maximumGap(int[] arr) {
        int n = arr.length;
        if(n <= 1) return 0;

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            minValue = Math.min(minValue, arr[i]);
        }

        int avgGap = (int)Math.ceil((double)(maxValue - minValue)/(double)(n - 1));
        if(avgGap == 0) return 0;

        int[] min = new int[n];
        int[] max = new int[n];
        for(int i = 0; i < n; i++) {
            min[i] = Integer.MAX_VALUE;
            max[i] = Integer.MIN_VALUE;
        }

        for(int i = 0; i < n; i++) {
            int index = (arr[i] - minValue) / avgGap;
            min[index] = Math.min(min[index], arr[i]);
            max[index] = Math.max(max[index], arr[i]);
        }

        int prev = max[0];
        int maxGap = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(min[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, min[i] - prev);
            prev = max[i];
        }
        return maxGap;
    }
}
