package com.vc.hard;

class L239 {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if(n == 0) return new int[0];

        int[] max_left = new int[n];
        int[] max_right = new int[n];

        int max = 0;
        for(int i = 0; i < n; i++) {
            if(i % k == 0) max_left[i] = arr[i];
            else max_left[i] = Math.max(max, arr[i]);
            max = max_left[i];
        }

        max = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(i % k == 0) max_right[i] = arr[i];
            else max_right[i] = Math.max(max, arr[i]);
            max = max_right[i];
        }

//         System.out.println("Left");
//         for(int i = 0; i < n; i++) {
//             System.out.print(max_left[i]+" ");
//         }

//         System.out.println("\nRight");
//         for(int i = 0; i < n; i++) {
//             System.out.print(max_right[i]+" ");
//         }

        int[] res = new int[n - k + 1];
        for(int i = 0 ; i < res.length; i++) {
            res[i] = Math.max(max_right[i], max_left[i + k - 1]);
        }
        return res;
    }
}
