package com.vc.medium;

class L769 {
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0) return 0;

        int n = arr.length, max = 0;

        int[] maxLeft = new int[n];
        maxLeft[0] = arr[0];
        for(int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(arr[i], maxLeft[i - 1]);
        }

        //for(int i = 0; i < n; i++) System.out.print(maxLeft[i]+" ");

        int[] minRight = new int[n];
        minRight[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(arr[i], minRight[i + 1]);
        }

        //for(int i = 0; i < n; i++) System.out.print(maxLeft[i]+" ");

        int res = 0;
        for(int i = 0; i + 1 < n; i++) {
            if(maxLeft[i] <= minRight[i + 1]) res++;
        }

        return res + 1;
    }
}
