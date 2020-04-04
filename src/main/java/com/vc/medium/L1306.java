package com.vc.medium;

class L1306 {
    public boolean canReach(int[] arr, int start) {
        if(start < 0 || start >= arr.length || arr[start] == -1) return false;

        if(arr[start] == 0) return true;

        int value = arr[start];
        arr[start] = -1;

        return canReach(arr, start + value) || canReach(arr, start - value);
    }
}
