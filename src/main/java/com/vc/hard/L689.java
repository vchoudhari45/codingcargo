package com.vc.hard;

class L689 {
    public int[] maxSumOfThreeSubarrays(int[] arr, int k) {
        int n = arr.length;
        if(n == 0) return new int[0];
        int[] sum = new int[n - k + 1];
        int[] left = new int[n - k + 1];
        int[] right = new int[n - k + 1];
        int[] res = new int[3];

        int total = 0;
        for(int i = 0; i < k; i++) total += arr[i];

        for(int i = k; i <= n; i++) {
            sum[i - k] = total;
            if(i < n) total += arr[i];
            total -= arr[i - k];
        }

        int max = 0;
        int bestIndex = 0;
        for(int i = 0; i < sum.length; i++) {
            //System.out.println("Max: "+max);
            if(max < sum[i]) {
                max = sum[i];
                bestIndex = i;
            }
            left[i] = bestIndex;
        }

        max = 0;
        bestIndex = sum.length - 1;
        for(int i = sum.length - 1; i >= 0; i--) {
            if(max <= sum[i]) {
                max = sum[i];
                bestIndex = i;
            }
            right[i] = bestIndex;
        }

//         System.out.println("Sum: ");
//         for(int i = 0; i < sum.length; i++) {
//             System.out.print(sum[i]+" ");
//         }

//         System.out.println("\nLeft: ");
//         for(int i = 0; i < left.length; i++) {
//             System.out.print(left[i]+" ");
//         }

//         System.out.println("\nRight: ");
//         for(int i = 0; i < right.length; i++) {
//             System.out.print(right[i]+" ");
//         }

        //System.out.println("\n");
        max = 0;
        for(int i = k; i + k < sum.length; i++) {
            int l = sum[left[i - k]];
            int m = sum[i];
            int r = sum[right[i + k]];
            //System.out.println("l: "+l+" r: "+r+" m: "+m);
            total = l + m + r;
            if(max < total) {
                max = total;
                res[0] = left[i - k];
                res[1] = i;
                res[2] = right[i + k];
            }
        }
        return res;
    }
}
