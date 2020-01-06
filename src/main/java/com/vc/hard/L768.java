package com.vc.hard;

class L768 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;

        int[] left = new int[n];
        left[0] = arr[0];
        for(int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        int[] right = new int[n];
        right[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], arr[i]);
        }

//         System.out.println("Left: ");
//         for(int i = 0; i < arr.length; i++) {
//             System.out.print(left[i]+" ");
//         }

//         System.out.println("\nRight: ");
//         for(int i = 0; i < arr.length; i++) {
//             System.out.print(right[i]+" ");
//         }

        int res = 1;
        for(int i = 0; i < arr.length - 1; i++) {
            if(left[i] <= right[i + 1]) res++;
        }

        return res;
    }
}
