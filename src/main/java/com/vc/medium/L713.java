package com.vc.medium;

class L713 {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if(arr == null || arr.length == 0) return 0;

        int start = 0, end = 0, product = arr[end++], n = arr.length;
        int res = product < k ? 1 : 0;
        while(end < n) {
            product = product * arr[end++];
            while(start < end && product >= k) {
                product = product / arr[start++];
            }
            res += end - start;
        }
        return res;
    }
}
