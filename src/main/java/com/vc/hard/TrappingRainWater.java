package com.vc.hard;

class TrappingRainWater {
    public int trap(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        int maxLeft = 0;
        int maxRight = 0;
        while(left <= right) {
            if(arr[left] <= arr[right]) {
                if(maxLeft < arr[left]) maxLeft = arr[left];
                else res += maxLeft - arr[left];
                left++;
            }
            else {
                if(maxRight < arr[right]) maxRight = arr[right];
                else res += maxRight - arr[right];
                right--;
            }
        }
        return res;
    }
}