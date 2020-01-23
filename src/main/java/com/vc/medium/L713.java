package com.vc.medium;

class L713 {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if(k <= 1) return 0;
        int left = 0, res = 0, product = 1;
        for(int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while(product >= k) {
                product /= arr[left++];
            }
            res += right - left + 1;
        }
        return res;
    }
}
